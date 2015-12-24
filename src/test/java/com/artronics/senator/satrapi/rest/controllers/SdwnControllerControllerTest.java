package com.artronics.senator.satrapi.rest.controllers;

import com.artronics.senator.satrapi.entities.SdwnController;
import com.artronics.senator.satrapi.entities.SdwnNetwork;
import com.artronics.senator.satrapi.helper.ControllerHelper;
import com.artronics.senator.satrapi.helper.TestConstants;
import com.artronics.senator.satrapi.services.SdwnControllerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SdwnControllerControllerTest
{
    String URI="/rest/networks/1/controllers/";

    @InjectMocks
    SdwnControllerController controller;

    @Mock
    SdwnControllerService controllerService;

    MockMvc mockMvc;

    SdwnNetwork sdwnNetwork;
    SdwnController sdwnController;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        sdwnNetwork = new SdwnNetwork(TestConstants.OUR_IP);
        sdwnNetwork.setId(1L);
        sdwnController = new SdwnController();
        sdwnController.setId(1L);
        sdwnController.setSdwnNetwork(sdwnNetwork);
    }

    @Test
    public void it_should_give_SdwnController() throws Exception
    {
        when(controllerService.findByNetwork(1L,1L)).thenReturn(sdwnController);
        String uri = ControllerHelper.buildUri(1L, 1L);

        mockMvc.perform(get(uri))
               .andDo(print())
               .andExpect(jsonPath("$.rid",is(1)))
               .andExpect(jsonPath("$.links[*].href",hasItem(
                       endsWith("networks/1/controllers/1"))))
               .andExpect(status().isOk())
        ;
    }

    @Test
    public void throw_exp_if_either_controller_or_network_does_not_exist() throws Exception
    {
        when(controllerService.findByNetwork(1L,11L)).thenReturn(null);
        String uri = ControllerHelper.buildUri(1L, 11L);

        mockMvc.perform(get(uri)).andExpect(status().isNotFound());

        when(controllerService.findByNetwork(123L,1L)).thenReturn(null);
        uri = ControllerHelper.buildUri(123L, 121L);

        mockMvc.perform(get(uri)).andExpect(status().isNotFound());

        when(controllerService.findByNetwork(123L,121L)).thenReturn(null);
        uri = ControllerHelper.buildUri(123L, 121L);

        mockMvc.perform(get(uri)).andExpect(status().isNotFound());
    }
}