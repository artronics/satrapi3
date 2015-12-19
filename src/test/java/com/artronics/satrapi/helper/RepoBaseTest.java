package com.artronics.satrapi.helper;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.repositories.DeviceConnectionRepo;
import com.artronics.satrapi.repositories.SdwnControllerRepo;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class RepoBaseTest
{
    @Autowired
    protected SdwnNetworkRepo networkRepo;

    @Autowired
    protected SdwnControllerRepo controllerRepo;

    @Autowired
    protected DeviceConnectionRepo connectionRepo;

    protected String someIp ="12.34.55.234";
    protected int numOfCtrl = 5;
    protected Long netId;

    /**
     * Before each test we persist a SdwnNetwork with ip address of someIp,
     * netId is the Id of this network.
     * For this entity we persist numOfCtrl.
     * CAUTION: Remember during Spring Container inside event we persist a SdwnNetwork
     * associated with this machine. see NetworkInitializer
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        //creates one SdwnNetwork with 5 controllers
        persisControllers(5);
    }

    @After
    public void after() throws Exception{
        networkRepo.deleteAll();
    }

    private void persisControllers(int num){
        netId=persisControllers(num,someIp);
    }

    protected Long persisControllers(int num,String ip){
        SdwnNetwork network = new SdwnNetwork(ip);

        List<SdwnController> controllers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            SdwnController e = new SdwnController();
            e.setSdwnNetwork(network);
            e.setSinkAddress(4L);
            controllers.add(e);
        }
        network.setControllers(controllers);
        networkRepo.save(network);

        return network.getId();
    }
}
