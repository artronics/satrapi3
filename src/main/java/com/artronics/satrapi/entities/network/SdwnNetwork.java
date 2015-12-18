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
