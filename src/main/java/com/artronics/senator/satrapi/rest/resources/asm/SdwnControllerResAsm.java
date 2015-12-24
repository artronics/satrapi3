package com.artronics.senator.satrapi.rest.resources.asm;

import com.artronics.senator.satrapi.entities.SdwnController;
import com.artronics.senator.satrapi.rest.controllers.SdwnControllerController;
import com.artronics.senator.satrapi.rest.resources.SdwnControllerRes;
import org.apache.log4j.Logger;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class SdwnControllerResAsm extends
                                  ResourceAssemblerSupport<SdwnController, SdwnControllerRes>
{
    private final static Logger log = Logger.getLogger(SdwnControllerResAsm.class);

    public SdwnControllerResAsm()
    {
        super(SdwnControllerController.class, SdwnControllerRes.class);
    }

    @Override
    public SdwnControllerRes toResource(SdwnController sdwnController)
    {
        SdwnControllerRes res = new SdwnControllerRes();

        res.setRid(sdwnController.getId());

        res.setSinkAddress(sdwnController.getSinkAddress());
        res.setDescription(sdwnController.getDescription());

        res.setCreated(sdwnController.getCreated());
        res.setUpdated(sdwnController.getUpdated());

        Long sdwnNetId = sdwnController.getSdwnNetwork().getId();

        res.add(linkTo(SdwnControllerController.class,sdwnNetId)
                        .slash(sdwnController.getId()).withSelfRel());

        return res;
    }
}
