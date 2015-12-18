package com.artronics.satrapi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="controllers")
public class SdwnController
{
    private Long id;

    protected String description;

    protected SdwnNetwork sdwnNetwork;

    protected Date created;
    protected Date updated;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "network_id", nullable = false)
    public SdwnNetwork getSdwnNetwork()
    {
        return sdwnNetwork;
    }

    public void setSdwnNetwork(SdwnNetwork sdwnNetwork)
    {
        this.sdwnNetwork = sdwnNetwork;
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
