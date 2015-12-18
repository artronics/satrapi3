package com.artronics.satrapi;

import org.apache.log4j.Logger;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "com.artronics.satrapi"
})
@EnableJpaRepositories(basePackages = {
        "com.artronics.satrapi.repositories",
})
@EntityScan(basePackages = {"com.artronics.satrapi.entities"})
@ImportResource("classpath:test-config.xml")
public class TestContextConfiguration
{
    private final static Logger log = Logger.getLogger(TestContextConfiguration.class);
}
