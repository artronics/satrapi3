package com.artronics.satrapi.services;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnControllerServiceTest
{
    static final String someIp = "123.31.3.6";
    @Autowired
    SdwnControllerService controllerService;

    @Autowired
    SdwnNetworkRepo networkRepo;

    @Test(expected = DataIntegrityViolationException.class)
    public void it_should_not_persis_if_there_is_no_SdwnNetwork()
    {
        SdwnController controller = createController();

        controllerService.save(controller);
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void it_should_not_persist_if_specify_SdwnNetwork_is_not_in_db()
    {
        SdwnNetwork sdwnNetwork = new SdwnNetwork(someIp);
        SdwnController controller = createController();
        controller.setSdwnNetwork(sdwnNetwork);

        controllerService.save(controller);
    }

    @Test
    public void it_should_save_controller()
    {
        SdwnController controller = persistController();

        assertNotNull(controller.getId());
    }

    @Ignore("I changed fetch strategy from EAGER to LAZY and test passed either way")
    @Test
    public void it_should_load_SdwnNetwork_EAGER_ly(){
        SdwnController controller = persistController();

        assertNotNull(controller.getSdwnNetwork());
        assertThat(controller.getSdwnNetwork().getIp(),equalTo(someIp));
    }

    private SdwnController createController()
    {
        return new SdwnController();
    }

    private SdwnController persistController(){
        SdwnNetwork sdwnNetwork = new SdwnNetwork(someIp);
        networkRepo.save(sdwnNetwork);
        SdwnController controller = createController();

        controller.setSdwnNetwork(sdwnNetwork);
        return controllerService.save(controller);
    }
}