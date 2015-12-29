package com.artronics.senator.controller;

import com.artronics.senator.helper.FakePacketFactory;
import com.artronics.senator.mocks.MockBeanDef;
import com.artronics.senator.network.SdwnNetworkService;
import com.artronics.senator.network.config.NetworkBeanDef;
import com.artronics.senator.packet.DevicePacket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NetworkBeanDef.class, MockBeanDef.class})
public class ControllerServiceTest
{
    @Autowired
    ControllerService controllerService;

    @Autowired
    SdwnNetworkService netService;

    FakePacketFactory factory = new FakePacketFactory();

    DevicePacket aDevPacket;

    @Before
    public void setUp() throws Exception
    {
        aDevPacket = factory.createADevPacket();

    }

    @Test
    public void it_should_add_ctrl_id_to_packet(){
        controllerService.addDevicePacket(aDevPacket);

//        assertThat(aDevPacket.);
    }

}