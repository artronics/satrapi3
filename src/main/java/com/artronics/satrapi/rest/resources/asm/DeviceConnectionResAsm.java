package com.artronics.satrapi.rest.resources.asm;

import com.artronics.satrapi.entities.DeviceConnection;
import com.artronics.satrapi.rest.controllers.DeviceConnectionController;
import com.artronics.satrapi.rest.resources.DeviceConnectionRes;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class DeviceConnectionResAsm extends ResourceAssemblerSupport<DeviceConnection,DeviceConnectionRes>
{
    public DeviceConnectionResAsm()
    {
        super(DeviceConnectionController.class, DeviceConnectionRes.class);
    }

    @Override
    public DeviceConnectionRes toResource(DeviceConnection entity)
    {
        DeviceConnectionRes res = new DeviceConnectionRes();

        res.setRid(entity.getId());

        res.setConnectionString(entity.getConnectionString());

        res.setCreated(entity.getCreated());
        res.setUpdated(entity.getUpdated());

        return res;
    }
}
