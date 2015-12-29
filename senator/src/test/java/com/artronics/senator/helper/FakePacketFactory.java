package com.artronics.senator.helper;

import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FakePacketFactory
{
    private final static Logger log = Logger.getLogger(FakePacketFactory.class);
    private final FakeBufferFactory buffFactory = new FakeBufferFactory();

    public DevicePacket createADevPacket(){
        return createDevDataPacket(30,0,10);
    }


    public DevicePacket createDevDataPacket(int src,int dst,int payloadLen){
        List<Integer> content = new ArrayList<>(buffFactory.createData(src,dst,payloadLen));

        return new DevicePacket(content);
    }
}
