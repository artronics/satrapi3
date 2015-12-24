package com.artronics.senator.satrapi.rest.resources;

import com.artronics.senator.satrapi.entities.DeviceConnection;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

public class DeviceConnectionRes extends ResourceSupport
{
    private Long rid;

    private String connectionString;

    private Date created;
    private Date updated;

    DeviceConnection toDeviceConnection(){
        DeviceConnection connection = new DeviceConnection();

        connection.setConnectionString(connectionString);

        return connection;
    }

    public Long getRid()
    {
        return rid;
    }

    public void setRid(Long rid)
    {
        this.rid = rid;
    }

    public String getConnectionString()
    {
        return connectionString;
    }

    public void setConnectionString(String connectionString)
    {
        this.connectionString = connectionString;
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
