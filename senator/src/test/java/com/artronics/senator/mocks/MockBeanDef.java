package com.artronics.senator.mocks;

import com.artronics.senator.network.controller.config.ControllerBeanDef;
import com.artronics.senator.network.controller.sdwn.device.connection.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ControllerBeanDef.class)
@ComponentScan(basePackages = {"com.artronics.senator.mocks",
"com.artronics.senator.packet"})
//@Profile("test")
public class MockBeanDef
{
    @Bean
    Connection getConnection(){
        return new MockConnection();
    }

}
