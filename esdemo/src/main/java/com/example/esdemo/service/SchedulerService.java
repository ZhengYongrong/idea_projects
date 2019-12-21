package com.example.esdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void schedulerHello(){
        System.out.println("hello...");
    }
}
