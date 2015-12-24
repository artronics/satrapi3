package com.artronics.senator.controller.device;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("deviceProperties")
public class DeviceProperties
{
    private final static Logger log = Logger.getLogger(DeviceProperties.class);

    String connectionString;
    Integer timeout;

    Integer startByte;
    Integer stopByte;

    public String getConnectionString()
    {
        return connectionString;
    }

    @Required
    @Value("${com.artronics.controller.device.connection.connection_string}")
    public void setConnectionString(String connectionString)
    {
        this.connectionString = connectionString;
    }

    public Integer getTimeout()
    {
        return timeout;
    }

    @Required
    @Value("${com.artronics.controller.device.connection.timeout}")
    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }

    public Integer getStartByte()
    {
        return startByte;
    }

    @Required
    @Value("${com.artronics.controller.device.buffer.startByte}")
    public void setStartByte(Integer startByte)
    {
        this.startByte = startByte;
    }

    public Integer getStopByte()
    {
        return stopByte;
    }

    @Required
    @Value("${com.artronics.controller.device.buffer.stopByte}")
    public void setStopByte(Integer stopByte)
    {
        this.stopByte = stopByte;
    }
}
