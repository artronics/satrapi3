package com.artronics.mocks;

import com.artronics.controller.device.connection.AbstractConnection;
import com.artronics.controller.device.exception.DeviceConnectionException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MockConnection extends AbstractConnection
{
    private final static Logger log = Logger.getLogger(MockConnection.class);

    @Override
    protected void initConnection()
    {

    }

    @Override
    public void open() throws DeviceConnectionException
    {

    }

    @Override
    public void close()
    {

    }
}
