package com.artronics.satrapi.rest.controllers;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.services.SdwnControllerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/networks/{networkId}/controllers")
public class SdwnControllerController
{
    private final static Logger log = Logger.getLogger(SdwnControllerController.class);

    @Autowired
    SdwnControllerService controllerService;

    @RequestMapping("/{id}")
    ResponseEntity<SdwnController> getSdwnController
            (@PathVariable Long networkId,@PathVariable Long id){

        SdwnController controller= controllerService.findOne(id);

        return new ResponseEntity<SdwnController>(HttpStatus.OK);
    }
}