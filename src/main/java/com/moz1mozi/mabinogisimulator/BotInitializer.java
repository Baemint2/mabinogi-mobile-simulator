package com.moz1mozi.mabinogisimulator;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BotInitializer {

    @Value("${discord.channel}")
    private String channelId;

    @Value("${discord.token}")
    private String discordBotToken;

    private final DiscordListener discordListener;

    private JDA jda;

    @PostConstruct
    public void init() throws InterruptedException {
        JDABuilder builder = JDABuilder.createDefault(discordBotToken);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);  // 메시지 콘텐츠를 활성화
        builder.addEventListeners(discordListener);  // 이벤트 리스너 등록
        builder.setAutoReconnect(true);

        // JDA 인스턴스 생성 및 준비 완료까지 대기
        this.jda = builder.build().awaitReady();

    }

    public void setupHourlyScheduler() {
        if (jda.getStatus() != JDA.Status.CONNECTED) return;

        // 공지 보낼 채널 ID 지정
        TextChannel channel = jda.getTextChannelById(Objects.requireNonNull(channelId));

        if (channel != null) {
            channel.sendMessage("🔔불길한 결계가 열렸습니다.").queue();
        }
    }

}
