package com.artronics.mocks;

import com.artronics.controller.config.ControllerBeanDef;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ControllerBeanDef.class)
//@Profile("test")
public class MockBeanDef
{

}
