package com.artronics.satrapi.repositories.jpa;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.helper.RepoBaseTest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class SdwnControllerRepoTest extends RepoBaseTest
{
    @Test
    public void it_should_EAGER_ly_load_sdwnNetwork(){
        SdwnController ctrl = aPersistedCtrl;

        assertNotNull(ctrl.getSdwnNetwork());
        assertThat(ctrl.getSdwnNetwork().getIp(),equalTo(someIp));
    }

    @Test
    public void test_findByNetwork_it_should_return_associated_SdwnNetwork(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(netId,aPersistedCtrl.getId());

        assertNotNull(persistedCnt.getSdwnNetwork());
        assertThat(persistedCnt.getSdwnNetwork().getIp(),equalTo(someIp));
    }

    @Test
    public void findByNetwork_should_return_null_if_there_is_no_controller(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(netId,3445L);

        assertNull(persistedCnt);
    }

    @Test
    public void findByNetwork_should_return_null_if_there_is_no_such_controller(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(netId,2400L);

        assertNull(persistedCnt);
    }

    @Test
    public void findByNetwork_if_there_is_no_network_return_null(){
        SdwnController persistedCnt = controllerRepo.findByNetwork(10L,aPersistedCtrl.getId());

        assertNull(persistedCnt);
    }

    @Test
    public void findByNetwork_should_return_null_if_SdwnNetwork_id_does_not_match(){
        SdwnNetwork otherNet = new SdwnNetwork("35.66.78.89");
        networkRepo.save(otherNet);
        Long otherNetId = otherNet.getId();

        SdwnController persistedCnt = controllerRepo.findByNetwork(otherNetId,aPersistedCtrl.getId());

        assertNull(persistedCnt);
    }
}