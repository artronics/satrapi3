package com.artronics.satrapi.repositories;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.helper.RepoBaseTest;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class SdwnNetworkRepoTest extends RepoBaseTest
{
    @Test
    public void test_findByIp()
    {
        SdwnNetwork persistedNet = networkRepo.findByIp(someIp);

        assertNotNull(persistedNet.getId());
        assertThat(persistedNet.getIp(), equalTo(someIp));
    }

    @Test
    public void it_should_EAGER_ly_fetch_associated_controllers()
    {
        SdwnNetwork persistedNet = networkRepo.findByIp(someIp);

        List<SdwnController> controllers = persistedNet.getControllers();

        assertNotNull(controllers);
        assertThat(controllers.size(), equalTo(5));
    }

    //we just test delete
    @Test
    public void it_should_cascade_ALL()
    {
        SdwnNetwork persistedNet = networkRepo.findByIp(someIp);
        //get first controller id
        Long contId = persistedNet.getControllers().get(0).getId();

        networkRepo.delete(persistedNet.getId());

        SdwnController ctrl = controllerRepo.findOne(contId);

        assertNull(ctrl);
    }

}