package com.example.crawlercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrawlerCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerCoreApplication.class, args);
    }
}
