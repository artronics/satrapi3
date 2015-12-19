package com.artronics.satrapi.repositories.jpa;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.repositories.SdwnControllerRepo;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnControllerRepoImplTest
{
    @Autowired
    SdwnControllerRepo controllerRepo;

    @Autowired
    SdwnNetworkRepo networkRepo;

    String someIp ="12.34.64.3";

    SdwnNetwork network;
    SdwnController controller;

    @Before
    public void setUp() throws Exception
    {
        network = new SdwnNetwork(someIp);
        networkRepo.save(network);

        controller = new SdwnController();
        controller.setSdwnNetwork(network);
        controller.setSinkAddress(8L);
        controllerRepo.save(controller);
    }

    @Test
    public void test_findByNetwork(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(network.getId(),controller.getId());

        assertNotNull(persistedCnt.getSdwnNetwork());
        assertThat(persistedCnt.getSdwnNetwork().getIp(),equalTo(someIp));
    }
}