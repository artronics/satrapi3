package com.artronics.senator.satrapi.repositories;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

public class PacketRepoTest extends RepoBaseTest
{
    @Test
    @Rollback(value = false)
    public void it_should_persist_a_packet(){
//        ControllerPacket p = new ControllerPacket();
//        p.setSourceCtrlId(23L);
//        NetworkPacket packet = new NetworkPacket(p);
//        packetRepo.save(packet);
    }
}