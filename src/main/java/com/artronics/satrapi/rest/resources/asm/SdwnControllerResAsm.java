package com.artronics.satrapi.rest.resources.asm;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.rest.controllers.SdwnControllerController;
import com.artronics.satrapi.rest.resources.SdwnControllerRes;
import org.apache.log4j.Logger;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class SdwnControllerResAsm extends
                                  ResourceAssemblerSupport<SdwnController,SdwnControllerRes>
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

        return res;
    }
}
