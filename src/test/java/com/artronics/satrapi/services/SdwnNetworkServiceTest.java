package com.artronics.satrapi.services;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnNetwork;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.artronics.satrapi.helper.TestConstants.OUR_IP;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnNetworkServiceTest
{
    @Autowired
    SdwnNetworkService networkService;

    SdwnNetwork sdwnNetwork = new SdwnNetwork(OUR_IP);
    @Before
    public void setUp() throws Exception
    {
    }

    @Ignore("In NetworkInitializer during container generation always a" +
            " SdwnNetwork is persisted if there is no one")
    @Test
    public void it_should_return_null_when_there_is_no_network(){
        assertNull(networkService.findByIp(OUR_IP));
    }
}