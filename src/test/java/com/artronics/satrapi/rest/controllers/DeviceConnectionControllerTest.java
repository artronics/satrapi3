package com.artronics.satrapi.rest.controllers;

import com.artronics.satrapi.helper.ControllerHelper;
import com.artronics.satrapi.services.DeviceConnectionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeviceConnectionControllerTest
{
    @InjectMocks
    DeviceConnectionController controller;

    @Mock
    DeviceConnectionService service;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void it_should_get_DeviceConnection() throws Exception
    {
        mockMvc.perform(get(ControllerHelper.buildUri(1L,1L,1L)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}