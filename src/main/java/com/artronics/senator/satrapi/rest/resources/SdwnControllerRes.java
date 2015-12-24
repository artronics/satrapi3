package com.artronics.senator.satrapi.rest.resources;

import com.artronics.senator.satrapi.entities.SdwnController;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class SdwnControllerRes extends ResourceSupport
{
    private Long rid;

    private Long sinkAddress;
    private String description;

    private Date created;
    private Date updated;

    public SdwnController toSdwnController(){
        SdwnController controller = new SdwnController();

        controller.setSinkAddress(sinkAddress);
        controller.setDescription(description);

        return controller;
    }

    public Long getRid()
    {
        return rid;
    }

    public void setRid(Long rid)
    {
        this.rid = rid;
    }

    public Long getSinkAddress()
    {
        return sinkAddress;
    }

    public void setSinkAddress(Long sinkAddress)
    {
        this.sinkAddress = sinkAddress;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }
}
