package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.rune.RuneItem;
import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;
import com.moz1mozi.mabinogisimulator.service.JsonParsingService;
import com.moz1mozi.mabinogisimulator.service.RuneFusionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static com.moz1mozi.mabinogisimulator.rune.RuneRarity.AVAILABLE_RARITIES;
import static com.moz1mozi.mabinogisimulator.rune.RuneRarity.RARITY_STYLES;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiscordListener extends ListenerAdapter {


    private final RuneFusionService runeFusionService;
    private final JsonParsingService jsonParsingService;

    private final Map<String, String> messageOwners = new ConcurrentHashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            log.info("event.getAuthor().isBot() : {}", event.getAuthor().isBot());
            return;
        }

        Message message = event.getMessage();
        String username = event.getAuthor().getName();
        log.info("author: {}", username);
        String content = message.getContentRaw();

        log.info("content: {}", content);
        if (content.equals("합성")) {
            List<Button> typeButtons = Arrays.stream(RuneType.values())
                    .map(type -> Button.primary(
                            type.name().toLowerCase(),
                            type.getDisplayName()
                    )).toList();
            event.getChannel().sendMessage("버튼을 눌러보세요!")
                    .setActionRow(typeButtons)
                    .queue(sentMessage -> messageOwners.put(sentMessage.getId(), username));

            log.info("버튼을 생성한 유저: {}", username);
        } else if (content.equals("항아리")) {
            event.getChannel().sendMessage("추가 예정입니다.").queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String componentId = event.getComponentId();
        String label = event.getComponent().getLabel();
        User user = event.getUser();

        log.info("componentId: {}", componentId);
        log.info("user: {}", user.getName());

        String messageId = event.getMessage().getId();
        String ownerId = messageOwners.get(messageId);

        if (ownerId != null && !ownerId.equals(user.getName())) {
            event.reply("이 버튼은 명령어를 실행한 사용자만 사용할 수 있습니다.").setEphemeral(true).queue();
            return;
        }
        String buttonType = componentId.split("-")[0];
        log.info("buttonType: {}", buttonType);
        if (buttonType.equals("weapon") || buttonType.equals("armor") || buttonType.equals("accessory") || buttonType.equals("emblem")) {
            List<Button> list = AVAILABLE_RARITIES.stream()
                    .map(runeRarity -> Button.of(RARITY_STYLES.get(runeRarity),
                            runeRarity.name().toLowerCase() + "-" + buttonType,
                            runeRarity.getDisplayName()
                    )).toList();
            event.editMessage(label + "을(를) 선택하셨습니다.\n합성할 등급을 선택해주세요.")
                    .setActionRow(list)
                    .queue(sentMessage -> messageOwners.put(sentMessage.getId(), ownerId));
        } else if (componentId.contains("-")) {
            String[] parts = componentId.split("-");
            String rarityStr = parts[0];
            String typeStr = parts[1];

            if (typeStr.contains(":")) {
                String[] typeParts = typeStr.split(":");
                typeStr = typeParts[0];
            }

            // 정보를 버튼 ID에 포함시킴
            Button yesButton = Button.success("yes_" + rarityStr + "_" + typeStr, "예");
            Button noButton = Button.danger("no_" + rarityStr + "_" + typeStr, "아니오");

            event.editMessage("촉매제를 사용하시겠습니까?")
                    .setActionRow(yesButton, noButton)
                    .queue(sentMessage -> messageOwners.put(sentMessage.getId(), ownerId));
            return;
        }

        if (componentId.startsWith("yes_") || componentId.startsWith("no_")) {

            // 버튼 ID에서 정보 추출
            String[] parts = componentId.split("_");
            boolean useCatalyst = parts[0].equals("yes");
            String rarityStr = parts[1];
            String typeStr = parts[2];

            RuneType runeType = getRuneType(typeStr);
            RuneRarity rarity = getRarity(rarityStr);

            log.info("촉매제 선택: {}, 룬 타입: {}, 희귀도: {}", useCatalyst ? "사용" : "미사용", runeType, rarity);

            FusionResult result = runeFusionService.attemptFusion(runeType, rarity, useCatalyst);

            String baseString = runeType.getDisplayName() + " " + rarity.getDisplayName();
            String initialMessage;

            if (result.isSuccess() || !useCatalyst) {
                // 성공했거나 촉매제를 사용하지 않은 경우 - 바로 결과 표시
                initialMessage = baseString + " 합성 결과\n\n";
                initialMessage += result.toString();

                event.editMessage(initialMessage).setComponents(Collections.emptyList()).queue();
                log.info("합성 결과: {}", result);
            } else {
                // 실패했고 촉매제를 사용한 경우 - 단계별 메시지 표시
                // 1. 첫 시도 실패 메시지
                log.info("첫 시도 실패, 재시도 예정");
                initialMessage = baseString + " 강화에 실패했습니다!\n\n🧪 촉매제의 힘으로 재시도합니다...";
                event.editMessage(initialMessage).setComponents(Collections.emptyList()).queue(updateMessage -> {
                    // 2. 지연 후 재시도 메시지
                    // 재시도 로직 실행 (재시도 로직은 별도 메서드로 구현)
                    log.info("[재시도]: runType: {}, rarity: {}", runeType, rarity);
                    FusionResult retryResult = runeFusionService.attemptFusionRetry(runeType, rarity);

                    // 최종 결과 메시지
                    String finalMessage = baseString + " 합성 결과\n\n";
                    finalMessage += "🧪 촉매제를 사용했습니다! (재시도 수행)\n\n";
                    finalMessage += retryResult.toString();

                    // 2초 후에 최종 결과 표시
                    updateMessage.editOriginal(finalMessage).setComponents(Collections.emptyList())
                            .queueAfter(2, TimeUnit.SECONDS);

                    log.info("재시도 결과: {}", retryResult);
                });

            }
        }
    }

    private static RuneRarity getRarity(String string) {
        return switch (string) {
            case "advanced" -> RuneRarity.ADVANCED;
            case "rare_i" -> RuneRarity.RARE_I;
            case "rare_ii" -> RuneRarity.RARE_II;
            case "elite" -> RuneRarity.ELITE;
            case "epic" -> RuneRarity.EPIC;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }

    private static RuneType getRuneType(String string) {
        return switch (string) {
            case "weapon" -> RuneType.WEAPON;
            case "armor" -> RuneType.ARMOR;
            case "accessory" -> RuneType.ACCESSORY;
            case "emblem" -> RuneType.EMBLEM;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}

