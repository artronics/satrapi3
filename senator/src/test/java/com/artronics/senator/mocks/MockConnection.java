package com.artronics.senator.mocks;

import com.artronics.senator.network.controller.sdwn.device.buffer.FakeConnectionBuffer;
import com.artronics.senator.network.controller.sdwn.device.connection.AbstractConnection;
import com.artronics.senator.network.controller.sdwn.device.exception.DeviceConnectionException;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.util.List;

public class MockConnection extends AbstractConnection
{
    private final static Logger log = Logger.getLogger(MockConnection.class);

    FakeConnectionBuffer fakeBuff = new FakeConnectionBuffer();

    public MockConnection()
    {

    }

    @Override
    protected void initConnection()
    {
    }

    @Override
    public void open() throws DeviceConnectionException
    {

    }
    public void addBuffer(List<Integer> intBuff){
        byte[] buff = FakeConnectionBuffer.convertToByteArray(intBuff);
        input = new ByteArrayInputStream(buff);
        bufferReceived();
    }

    @Override
    public void close()
    {

    }
}
