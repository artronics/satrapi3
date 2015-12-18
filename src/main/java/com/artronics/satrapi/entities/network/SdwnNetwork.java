package com.artronics.satrapi.entities.network;

import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.beans.Transient;

@Entity
public class SdwnNetwork
{
    private String ip;

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }
}
