package com.artronics.senator.satrapi.rest.controllers;

import com.artronics.senator.satrapi.entities.SdwnController;
import com.artronics.senator.satrapi.rest.exceptions.NotFoundException;
import com.artronics.senator.satrapi.rest.resources.SdwnControllerRes;
import com.artronics.senator.satrapi.rest.resources.asm.SdwnControllerResAsm;
import com.artronics.senator.satrapi.services.SdwnControllerService;
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
    ResponseEntity<SdwnControllerRes> getSdwnController
            (@PathVariable Long networkId,@PathVariable Long id){

        SdwnController controller= controllerService.findByNetwork(networkId,id);
        if (controller == null) {
            throw new NotFoundException("There is no such entities. Either SdwnNetwork or SdwnController");
        }

        SdwnControllerRes res = new SdwnControllerResAsm().toResource(controller);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
