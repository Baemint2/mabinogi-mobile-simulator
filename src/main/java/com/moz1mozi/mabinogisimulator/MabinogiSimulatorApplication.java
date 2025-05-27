package com.moz1mozi.mabinogisimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MabinogiSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MabinogiSimulatorApplication.class, args);
    }

}
