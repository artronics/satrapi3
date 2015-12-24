package com.artronics.controller.device.serialPort;

import com.artronics.controller.device.connection.Connection;
import gnu.io.CommPortIdentifier;
import org.apache.log4j.Logger;

public class SerialPortConnectionWrapper implements Connection<CommPortIdentifier>
{
    private final static Logger log = Logger.getLogger(SerialPortConnectionWrapper.class);
    private CommPortIdentifier portIdentifier;

    public SerialPortConnectionWrapper(CommPortIdentifier portIdentifier)
    {
        this.portIdentifier = portIdentifier;
    }

    @Override
    public void open()
    {

    }

    @Override
    public void close()
    {

    }
}
