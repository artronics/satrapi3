package com.artronics.senator.satrapi.rest.controllers;

import com.artronics.senator.satrapi.rest.resources.DeviceConnectionRes;
import com.artronics.senator.satrapi.services.DeviceConnectionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/networks/{networkId}/controllers/{controllerId}/device_connections")
public class DeviceConnectionController
{
    private final static Logger log = Logger.getLogger(DeviceConnectionController.class);

    @Autowired
    DeviceConnectionService connectionService;

    @RequestMapping("/{id}")
    ResponseEntity<DeviceConnectionRes> get(@PathVariable Long networkId,
                                            @PathVariable Long controllerId,
                                            @PathVariable Long id){


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
