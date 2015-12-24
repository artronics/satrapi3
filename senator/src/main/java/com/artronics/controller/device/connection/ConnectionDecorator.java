package com.artronics.controller.device.connection;

import com.artronics.controller.device.DeviceProperties;
import com.artronics.event.DeviceInputBufferIsReady;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class ConnectionDecorator<C> implements Connection<C>
{
    private final static Logger log = Logger.getLogger(ConnectionDecorator.class);

    private static final int MAX_PACKET_LENGTH = 255;

    @Autowired
    private ApplicationEventPublisher publisher;


    protected String driverName= this.toString();

    protected Connection<C> connection;

    protected DeviceProperties deviceProperties;

    protected InputStream input=null;
    protected OutputStream output=null;

    public ConnectionDecorator()
    {
    }

    @PostConstruct
    public void initBean(){
        initConnection();
    }

    protected abstract void initConnection();

    protected void bufferReceived(){
        try {

            final byte[] buff = new byte[MAX_PACKET_LENGTH];
            final int length = input.read(buff, 0, MAX_PACKET_LENGTH);
            final ArrayList<Integer> intBuff = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                //convert signed value to unsigned
                intBuff.add(buff[i] & 0xFF);
            }

            fireBufferReceived(intBuff);

        }catch (IOException e) {
            e.printStackTrace();
            log.error("IO exp while reading buffer from driver:" + getDriverName());
        }

    }
    @Autowired
    public void setDeviceProperties(DeviceProperties deviceProperties)
    {
        this.deviceProperties = deviceProperties;
    }

    public String getDriverName()
    {
        return driverName;
    }

    public void fireBufferReceived(List<Integer> buffer){
        DeviceInputBufferIsReady event = new DeviceInputBufferIsReady(this,buffer);
        publisher.publishEvent(event);
    }
}
