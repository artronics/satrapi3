package com.artronics.senator.network.controller.sdwn.device.connection;

import com.artronics.senator.mocks.MockBeanDef;
import com.artronics.senator.mocks.MockConnection;
import com.artronics.senator.network.controller.sdwn.device.DeviceConnectionServiceImpl;
import com.artronics.senator.network.controller.sdwn.device.buffer.FakeConnectionBuffer;
import com.artronics.senator.network.controller.sdwn.device.exception.DeviceConnectionException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockBeanDef.class)
public class DeviceConnectionServiceImplTest
{
    @Autowired
//    @InjectMocks
    @Spy
    DeviceConnectionServiceImpl connectionService;

    @Autowired
//    @Mock
            MockConnection connection;


    FakeConnectionBuffer fakeBuff = new FakeConnectionBuffer();

    @Before
    public void setUp() throws Exception
    {
//        connectionService = new DeviceConnectionServiceImpl();
//        connection = new MockConnection();
//        connectionService.setConnection();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void it() throws DeviceConnectionException
    {
        List<Integer> buff = fakeBuff.getFirstOne();
        connection.addBuffer(buff);

        System.out.println("kir");
    }
}