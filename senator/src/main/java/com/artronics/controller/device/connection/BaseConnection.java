package com.artronics.controller.device.connection;

import com.artronics.controller.device.exception.DeviceConnectionException;
import org.apache.log4j.Logger;

public class BaseConnection extends ConnectionDecorator
{
    private final static Logger log = Logger.getLogger(BaseConnection.class);

    @Override
    public void open() throws DeviceConnectionException
    {

    }

    @Override
    public void close()
    {

    }

    @Override
    protected void initConnection()
    {

    }
}
