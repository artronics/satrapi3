package com.artronics.controller;

import com.artronics.controller.config.ControllerBeanDef;
import com.artronics.controller.device.connection.Connection;
import com.artronics.controller.device.exception.DeviceConnectionException;
import com.artronics.controller.device.serialPort.SerialPortConnection;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ControllerContainer
{
    private final static Logger log = Logger.getLogger(ControllerContainer.class);

    public static void main(String[] args) throws DeviceConnectionException
    {
        AnnotationConfigApplicationContext cnt = new AnnotationConfigApplicationContext(
                ControllerBeanDef.class);

        Connection connection = cnt.getBean(SerialPortConnection.class);
        connection.open();
    }
}
