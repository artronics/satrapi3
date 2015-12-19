package com.artronics.satrapi.repositories;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnNetwork;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.artronics.satrapi.helper.TestConstants.OUR_IP;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnNetworkRepoTest
{
    String someIp = "43.22.11.67";

    @Autowired
    SdwnNetworkRepo networkRepo;

    SdwnNetwork network;

    @Before
    public void setUp() throws Exception
    {
        network = new SdwnNetwork(someIp);
        networkRepo.save(network);

        SdwnNetwork ourNet = new SdwnNetwork(OUR_IP);
        networkRepo.save(ourNet);
    }

    @Test
    public void test_findByIp(){
        SdwnNetwork persistedNet = networkRepo.findByIp(someIp);

        assertNotNull(persistedNet.getId());
        assertThat(persistedNet.getIp(),equalTo(someIp));
    }
}