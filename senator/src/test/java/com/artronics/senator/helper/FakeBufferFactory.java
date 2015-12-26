package com.artronics.senator.helper;

import com.artronics.senator.packet.Packet;
import com.artronics.senator.packet.SdwnPacketHelper;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeBufferFactory
{
    private final static Logger log = Logger.getLogger(FakeBufferFactory.class);

    public static List<Integer> createABuffer(){
        List<Integer> buff = new ArrayList<>(createAHeader());
        buff.addAll(createPayload(10));

        return buff;
    }
    public static List<Integer> createPayload(int len){
        List<Integer> pl = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            pl.add(i);
        }

        return pl;
    }

    public static List<Integer> createHeader(int src, int dst, int len, Packet.Type type){
        return new ArrayList<>(Arrays.asList(
                len,
                Packet.DEF_NET_ID,
                SdwnPacketHelper.getLowAddress(src),
                SdwnPacketHelper.getHighAddress(src),
                SdwnPacketHelper.getLowAddress(dst),
                SdwnPacketHelper.getHighAddress(dst),
                type.getValue(),
                Packet.DEF_MAX_TTL,
                SdwnPacketHelper.getLowAddress(0),
                SdwnPacketHelper.getHighAddress(0)
        ));
    }
    public static List<Integer> createAHeader(){
        return createHeader(30, 0, 20, Packet.Type.DATA);
    }
}
