package com.forezp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Scheduled(cron = "0 0/1 * * * ?") // 每10分钟执行一次
    public void getToken() {
        logger.info("getToken定时任务启动");
    }
}