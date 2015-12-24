package com.artronics.controller.config;

import com.artronics.controller.device.connection.Connection;
import com.artronics.controller.device.serialPort.SerialPortConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan(basePackages = {"com.artronics.controller"})
@PropertySource("classpath:controller-defaults.properties")
@PropertySource("classpath:device-defaults.properties")
public class ControllerBeanDef
{
    @Autowired
    Environment env;

    @Bean
    @Primary
    @DependsOn("deviceProperties")
    Connection getConnection(){
        return new SerialPortConnection();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
