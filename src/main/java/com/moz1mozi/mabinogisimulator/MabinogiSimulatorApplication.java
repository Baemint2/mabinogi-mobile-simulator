package com.moz1mozi.mabinogisimulator;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

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
        JDA jda = builder.build().awaitReady();

        String guildId = "1269683981595709552";
        // 글로벌 슬래시 커맨드 등록 (모든 서버에 적용, 최대 1시간 소요)
        Objects.requireNonNull(jda.getGuildById(guildId)).updateCommands().addCommands(
                Commands.slash("ping", "봇의 핑 확인"),
                Commands.slash("hello", "인사하기"),
                Commands.slash("echo", "메시지 반복")
                        .addOption(OptionType.STRING, "message", "반복할 메시지", true),
                Commands.slash("meeting", "회의 채널 생성")
        ).queue();

        System.out.println("봇이 성공적으로 시작되었습니다: " + jda.getSelfUser().getName());
        System.out.println("글로벌 슬래시 커맨드가 등록되었습니다. (적용까지 최대 1시간 소요)");

    }

}
