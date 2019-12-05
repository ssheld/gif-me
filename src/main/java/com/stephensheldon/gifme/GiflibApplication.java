package com.stephensheldon.gifme;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: Stephen Sheldon 11/21/19
 **/
@SpringBootApplication
public class GiflibApplication   {

    private static Logger logger = LoggerFactory.getLogger(GiflibApplication.class);

    public static void main(String[] args) {
        logger.info("Starting application!");
        SpringApplication.run(GiflibApplication.class, args);
        logger.info("Application has started!");
    }
}
