package com.shivanshu.springdepinj.config;

import com.shivanshu.springdepinj.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.shivanshu.springdepinj.common.Coach;

@Configuration
public class SportConfig {
    // bean id defaults to method name
    // @Bean
    // change bean id
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
