package com.idriving.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.idriving.service" })
public class SpringRootConfig {
}