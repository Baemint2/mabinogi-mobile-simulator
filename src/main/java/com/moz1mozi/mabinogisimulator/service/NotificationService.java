package com.moz1mozi.mabinogisimulator.service;

import com.moz1mozi.mabinogisimulator.BotInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final BotInitializer botInitializer;

    // 결계 스케쥴러
    @Scheduled(cron = "0 0 * * * *")
    public void scheduleHourlyNotification() {
        botInitializer.setupHourlyScheduler();
    }
}

