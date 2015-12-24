package com.artronics.controller.device.connection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DeviceConnectionServiceImpl implements DeviceConnectionService
{
    private final static Logger log = Logger.getLogger(DeviceConnectionServiceImpl.class);

    Connection connection;

    @Override
    public void init()
    {

    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
}
