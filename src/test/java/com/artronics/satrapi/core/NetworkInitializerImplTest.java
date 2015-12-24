package com.artronics.satrapi.core;

import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.helper.TestConstants;
import com.artronics.satrapi.services.SdwnNetworkService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

public class NetworkInitializerImplTest
{
    @InjectMocks
    NetworkInitializerImpl initializer;

    @Mock
    SdwnNetworkService networkService;

    SdwnNetwork sdwnNetwork=new SdwnNetwork(TestConstants.OUR_IP);

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(initializer, "ip", TestConstants.OUR_IP);
    }

    @Test
    public void it_should_look_for_a_SdwnNetwork_with_ourIp(){
        initializer.initSdwnNetwork();
        verify(networkService).findByIp(TestConstants.OUR_IP);
    }

    @Test
    public void it_should_create_a_sdwnNetwork_if_there_is_no_one(){
        initializer.initSdwnNetwork();
        when(networkService.findByIp(TestConstants.OUR_IP)).thenReturn(null);

        verify(networkService,times(1)).findByIp(TestConstants.OUR_IP);
        verify(networkService,times(1)).save(any(SdwnNetwork.class));
        verifyNoMoreInteractions(networkService);
    }

}