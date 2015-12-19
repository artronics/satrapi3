package com.artronics.satrapi.repositories;

import com.artronics.satrapi.TestContextConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class DeviceConnectionRepoTest
{
    @Autowired
    DeviceConnectionRepo connectionRepo;

    @Autowired
    SdwnControllerRepo controllerRepo;

    String someIp ="6.234.64.3";

    @Before
    public void setUp() throws Exception
    {


    }
}