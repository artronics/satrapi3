package com.artronics.senator.packet.services;

import com.artronics.senator.packet.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PacketLoggerServiceImpl implements PacketLoggerService
{
    private final static Logger log = Logger.getLogger(PacketLoggerServiceImpl.class);

    private final static Logger DEVICE = Logger.getLogger("com.artronics.senator.packet.logger.device");
    private final static Logger SDWN = Logger.getLogger("com.artronics.senator.packet.logger.sdwn");
    private final static Logger CTRL = Logger.getLogger("com.artronics.senator.packet.logger.controller");
    private final static Logger NET = Logger.getLogger("com.artronics.senator.packet.logger.network");

    @Override
    public <P extends Packet> void log(P packet)
    {
        PacketLogger.log(packet);
    }

    static class PacketLogger{
        static <P extends Packet> void  log(P packet){
            if (packet instanceof DevicePacket){
                DEVICE.debug(packet.toLogger());
            }
            else if(packet instanceof SdwnPacket){
                SDWN.debug(packet.toLogger());
            }
            else if(packet instanceof ControllerPacket){
                CTRL.debug(packet.toLogger());
            }
            else if(packet instanceof NetworkPacket){
                NET.debug(packet.toLogger());
            }
            else {
                log.error("Attempt to log a packet with incorrect type of: " +packet.getClass());
            }
        }
    }
}
