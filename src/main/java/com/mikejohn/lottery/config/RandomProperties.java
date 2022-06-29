package com.mikejohn.lottery.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.random")
@Getter
@Setter
public class RandomProperties {
    private String host;
}
