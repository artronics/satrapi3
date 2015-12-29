package com.artronics.senator.integration;

import com.artronics.senator.controller.ControllerService;
import com.artronics.senator.helper.FakePacketFactory;
import com.artronics.senator.mocks.MockBeanDef;
import com.artronics.senator.network.SdwnNetworkService;
import com.artronics.senator.network.config.NetworkBeanDef;
import com.artronics.senator.packet.DevicePacket;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NetworkBeanDef.class, MockBeanDef.class})
public class PacketFlowTest
{
}
