package com.artronics.satrapi.core.config;

import com.artronics.satrapi.repositories.RepositoryConfig;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
        "com.artronics.satrapi.repositories",
"com.artronics.satrapi.rest",
"com.artronics.satrapi.services"})
@PropertySource("classpath:application-prod.properties")
@Import(RepositoryConfig.class)
public class SatrapiBeanConfig
{
    private final static Logger log = Logger.getLogger(SatrapiBeanConfig.class);
}
