package com.moz1mozi.mabinogisimulator;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MabinogiSimulatorApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(MabinogiSimulatorApplication.class, args);
        DiscordBotToken discordBotToken = context.getBean(DiscordBotToken.class);
        DiscordListener myDiscordBot = context.getBean(DiscordListener.class);

        JDABuilder builder = JDABuilder.createDefault(discordBotToken.getDiscordBotToken());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);  // 메시지 콘텐츠를 활성화
        builder.addEventListeners(myDiscordBot);  // 이벤트 리스너 등록
        builder.setAutoReconnect(true);

        // JDA 인스턴스 생성 및 준비 완료까지 대기
        builder.build().awaitReady();
    }

}
