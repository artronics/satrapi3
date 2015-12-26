package com.artronics.senator.network.config;

import com.artronics.senator.controller.config.ControllerBeanDef;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "com.artronics.senator.network",
        "com.artronics.senator.packet"
})
@Import(ControllerBeanDef.class)
public class NetworkBeanDef
{
    private final static Logger log = Logger.getLogger(NetworkBeanDef.class);
}
