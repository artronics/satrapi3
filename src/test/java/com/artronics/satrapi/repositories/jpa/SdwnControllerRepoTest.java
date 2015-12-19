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
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnControllerRepoTest
{
    @Autowired
    SdwnControllerRepo controllerRepo;

    @Autowired
    SdwnNetworkRepo networkRepo;

    String someIp ="12.34.64.3";

    Long ctrlId;

    Long netId;
    Long otherNetId;

    @Before
    public void setUp() throws Exception
    {
        SdwnNetwork network = new SdwnNetwork(someIp);
        networkRepo.save(network);
        netId = network.getId();

        SdwnController controller = new SdwnController();
        controller.setSdwnNetwork(network);
        controller.setSinkAddress(8L);
        controllerRepo.save(controller);
        ctrlId = controller.getId();

        SdwnNetwork otherNet = new SdwnNetwork("33.45.66.75");
        networkRepo.save(otherNet);
        otherNetId = otherNet.getId();
    }

    @Test
    public void it_should_EAGER_ly_load_sdwnNetwork(){
        SdwnController ctrl = controllerRepo.findOne(ctrlId);

        assertNotNull(ctrl);
        assertNotNull(ctrl.getSdwnNetwork());
        assertThat(ctrl.getSdwnNetwork().getIp(),equalTo(someIp));
    }

    @Test
    public void test_findByNetwork_it_should_return_associated_SdwnNetwork(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(netId,ctrlId);

        assertNotNull(persistedCnt.getSdwnNetwork());
        assertThat(persistedCnt.getSdwnNetwork().getIp(),equalTo(someIp));
    }

    @Test
    public void findByNetwork_should_return_null_if_there_is_no_such_controller(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(netId,24L);

        assertNull(persistedCnt);
    }
    @Test
    public void findByNetwork_if_there_is_no_network_return_null(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(10L,ctrlId);

        assertNull(persistedCnt);
    }

    @Test
    public void findByNetwork_should_return_null_if_SdwnNetwork_id_does_not_match(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(otherNetId,ctrlId);

        assertNull(persistedCnt);
    }
}