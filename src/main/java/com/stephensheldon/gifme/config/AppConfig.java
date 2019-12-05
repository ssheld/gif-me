package com.stephensheldon.gifme.config;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Author: Stephen Sheldon 11/21/19
 **/
@Configuration
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public Hashids hashids() {
        return new Hashids(env.getProperty("giflib.hash.salt"),8);

    }
}
