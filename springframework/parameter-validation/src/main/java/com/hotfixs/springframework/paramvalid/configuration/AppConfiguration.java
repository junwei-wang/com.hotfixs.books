package com.hotfixs.springframework.paramvalid.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author wangjunwei
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hotfixs.springframework.paramvalid")
public class AppConfiguration {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
