package com.artronics.satrapi;

import com.artronics.satrapi.core.NetworkFinalizer;
import com.artronics.satrapi.core.SatrapiInitializer;
import com.artronics.satrapi.core.config.SatrapiBeanConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class SatrapiApplication implements
                                ApplicationListener<ContextRefreshedEvent>, DisposableBean
{
    private final static Logger log = Logger.getLogger(SatrapiApplication.class);

    @Autowired
    private SatrapiInitializer initializer;

    @Autowired
    private NetworkFinalizer finalizer;

    public static void main(String[] args)
    {
        log.info("Starting Satrapi...");
        log.debug("Starting main Context.");
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(SatrapiApplication.class,SatrapiBeanConfig.class)
                .run(args);
//        SpringApplication.run(SatrapiApplication.class, args);
//        AnnotationConfigApplicationContext satrapiContext = new AnnotationConfigApplicationContext(
//                SatrapiBeanConfig.class);
//        satrapiContext.start();
    }

    @Override
    public void onApplicationEvent
            (ContextRefreshedEvent contextRefreshedEvent)
    {
        initializer.initSdwnNetwork();
    }

    @Override
    public void destroy() throws Exception
    {

    }
}
