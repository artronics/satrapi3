package com.artronics.satrapi.rest.controllers;

import com.artronics.satrapi.services.SdwnControllerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.artronics.satrapi.helper.TestConstants.OUR_IP;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SdwnControllerControllerTest
{
    String URI="/rest/networks/"+OUR_IP+"/controllers/";

    @InjectMocks
    SdwnControllerController controller;

    @Mock
    SdwnControllerService controllerService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void it_should_give_SdwnController() throws Exception
    {
        mockMvc.perform(get(URI+1))
               .andExpect(status().isOk())
        .andDo(print());
    }
}