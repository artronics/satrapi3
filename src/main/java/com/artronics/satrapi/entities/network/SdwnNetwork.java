package com.artronics.satrapi.entities.network;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "network")
public class SdwnNetwork
{
    protected String ip;
    protected String description;

    protected Date created;
    protected Date updated;

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

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
