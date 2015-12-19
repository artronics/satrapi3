package com.artronics.satrapi.repositories;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.artronics.satrapi.helper.TestConstants.OUR_IP;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnNetworkRepoTest
{
    String someIp = "43.22.11.67";

    @Autowired
    SdwnNetworkRepo networkRepo;

    @Autowired
    SdwnControllerRepo controllerRepo;

    Long netId;


    @Before
    public void setUp() throws Exception
    {
        //creates one SdwnNetwork with 5 controllers
        persisControllers();

        SdwnNetwork ourNet = new SdwnNetwork(OUR_IP);
        networkRepo.save(ourNet);
    }

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
        assertThat(controllers.size(),equalTo(5));
    }

    //we just test delete
    @Test
    public void it_should_cascade_ALL(){
        SdwnNetwork persistedNet = networkRepo.findByIp(someIp);
        //get first controller id
        Long contId = persistedNet.getControllers().get(0).getId();

        networkRepo.delete(persistedNet.getId());

        SdwnController ctrl = controllerRepo.findOne(contId);

        assertNull(ctrl);
    }

    private void persisControllers(){
        SdwnNetwork network = new SdwnNetwork(someIp);

        List<SdwnController> controllers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SdwnController e = new SdwnController();
            e.setSdwnNetwork(network);
            e.setSinkAddress(4L);
            controllers.add(e);
        }
        network.setControllers(controllers);
        networkRepo.save(network);
        netId = network.getId();
    }
}