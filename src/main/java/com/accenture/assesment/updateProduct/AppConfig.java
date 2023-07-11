package com.accenture.assesment.updateProduct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class AppConfig {
    @Bean
    public ReentrantLock reentrantLock() {
        return new ReentrantLock();
    }
}
