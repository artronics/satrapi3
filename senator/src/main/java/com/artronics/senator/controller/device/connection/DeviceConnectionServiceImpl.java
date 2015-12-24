package com.artronics.senator.controller.device.connection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
}
