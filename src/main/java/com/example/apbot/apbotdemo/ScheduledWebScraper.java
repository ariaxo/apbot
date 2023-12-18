package com.example.apbot.apbotdemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledWebScraper {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 初始延迟为0，每隔一定时间执行一次任务
        scheduler.scheduleAtFixedRate(() -> {
            String url = "https://order.mandarake.co.jp/order/listPage/list?keyword=angel%20philia&lang=zh"; 

            try {
                SimpleWebScraper scraper = new SimpleWebScraper();
                scraper.scrape(url);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.HOURS); // 每隔1小时执行一次

        // 在需要停止监控时，关闭 scheduler
        // scheduler.shutdown();
    }
}

