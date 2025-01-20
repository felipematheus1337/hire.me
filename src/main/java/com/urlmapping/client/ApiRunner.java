package com.urlmapping.client;


import com.urlmapping.dtos.CreateURLDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class ApiRunner implements ApplicationRunner {

    private final UrlMappingClient client;
    private static final Logger logger = LoggerFactory.getLogger(ApiRunner.class);

    @Autowired
    private Environment environment;

    public ApiRunner(UrlMappingClient client) {
        this.client = client;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String activeProfile = environment.getProperty("spring.profiles.active");
        logger.info("Active profile: {}", activeProfile);
        System.out.println(Arrays.toString(environment.getActiveProfiles()));

        if (activeProfile.equals("test")) {
            String randomURLToTest = UUID.randomUUID().toString().substring(0, 7);
            String randomAliasToTest = UUID.randomUUID().toString().substring(0, 4);
            var createdUrlResponse = client.createShortenURL(randomURLToTest, randomAliasToTest);
            logger.info("Shortened URL Created: {}", createdUrlResponse);
        }

    }

}
