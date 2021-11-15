package com.example.quanlycacloaitramdo.config;

import com.example.quanlycacloaitramdo.entity.DeviceValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfig {
    @Bean
    public DeviceValidator validator() {
        return new DeviceValidator();
    }
}
