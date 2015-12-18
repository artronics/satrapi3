package com.artronics.satrapi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "networks")
public class SdwnNetwork
{
    protected String ip;

    protected Date created;
    protected Date updated;

    public SdwnNetwork()
    {
    }

    public SdwnNetwork(String ip)
    {
        this.ip = ip;
    }

    @Id
    @Column(name = "ip",nullable = false,unique = true)
    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
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

    @PrePersist
    protected void onCreate()
    {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate()
    {
        updated = new Date();
    }

}
