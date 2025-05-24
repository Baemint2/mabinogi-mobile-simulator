package com.moz1mozi.mabinogisimulator;

import com.moz1mozi.mabinogisimulator.rune.RuneRarity;
import com.moz1mozi.mabinogisimulator.rune.RuneType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiscordListener extends ListenerAdapter {


    private final RuneFusionService runeFusionService;
    @Value("${discord.channel}")
    String channelId;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot() || !event.getChannel().getId().equals(channelId)) {
            log.info("event.getAuthor().isBot() : {}", event.getAuthor().isBot());
            log.info("event.getChannel().getId() : {}", event.getChannel().getId().equals(channelId));
            return;
        }

        Message message = event.getMessage();
        String content = message.getContentRaw();

        log.info("content: {}", content);
        if(content.equals("test")) {
            Button weaponButton = Button.primary("weapon", "무기");
            Button armorButton = Button.primary("armor", "방어구");
            Button accessoryButton = Button.primary("accessory", "장신구");
            Button emblemButton = Button.primary("emblem", "엠블럼");
            event.getChannel().sendMessage("버튼을 눌러보세요!")
                    .setActionRow(weaponButton, armorButton, accessoryButton, emblemButton)
                    .queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String id = event.getComponentId();
        String label = event.getComponent().getLabel();
        log.info("id: {}", id);
        if (id.equals("weapon") || id.equals("armor") || id.equals("accessory") || id.equals("emblem") ) {
            Button advancedButton = Button.secondary(RuneRarity.ADVANCED.name().toLowerCase() + "-" + id, RuneRarity.ADVANCED.getDisplayName());
            Button rareIButton = Button.primary(RuneRarity.RARE_I.name().toLowerCase() + "-" + id, RuneRarity.RARE_I.getDisplayName());
            Button rareIIButton = Button.primary(RuneRarity.RARE_II.name().toLowerCase() + "-" + id, RuneRarity.RARE_II.getDisplayName());
            Button eliteButton = Button.success(RuneRarity.ELITE.name().toLowerCase() + "-" + id, RuneRarity.ELITE.getDisplayName());
            Button epicButton = Button.danger(RuneRarity.EPIC.name().toLowerCase() + "-" + id, RuneRarity.EPIC.getDisplayName());
            event.editMessage(label + "을(를) 선택하셨습니다.\n합성할 등급을 선택해주세요.")
                    .setActionRow(advancedButton, rareIButton, rareIIButton, eliteButton, epicButton)
                    .queue();

            log.info(epicButton.getId());
        } else if (id.contains("-")) {
            String[] parts = id.split("-");
            String rarityStr = parts[0];
            String typeStr = parts[1];

            log.info("type: {}", typeStr);
            RuneType runeType = getRuneType(typeStr);
            RuneRarity rarity = getRarity(rarityStr);
            FusionResult result = runeFusionService.attemptFusion(runeType, rarity);

            String message = "🔄 " + runeType.getDisplayName() + "의 " + rarity.getDisplayName() + " 강화를 시도하고 있습니다...\n\n" + result.toString();
            event.editMessage(message).setComponents(Collections.emptyList()).queue();

            log.info("result: {}", result);

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

