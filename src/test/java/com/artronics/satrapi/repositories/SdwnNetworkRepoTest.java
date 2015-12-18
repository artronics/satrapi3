package com.artronics.satrapi.repositories;

import com.artronics.satrapi.TestContextConfiguration;
import com.artronics.satrapi.core.NetworkInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class SdwnNetworkRepoTest
{
    @Autowired
    SdwnNetworkRepo networkRepo;

    @Autowired
    NetworkInitializer initializer;

    @Before
    public void setUp() throws Exception
    {


    }

    @Test
    public void it(){

    }
}