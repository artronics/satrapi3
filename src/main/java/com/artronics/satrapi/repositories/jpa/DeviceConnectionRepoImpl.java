package com.artronics.satrapi.repositories.jpa;

import com.artronics.satrapi.entities.DeviceConnection;
import com.artronics.satrapi.repositories.DeviceConnectionCustomRepo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeviceConnectionRepoImpl implements DeviceConnectionCustomRepo
{
    private final static Logger log = Logger.getLogger(DeviceConnectionRepoImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public DeviceConnection findByController(Long controllerId, Long id)
    {
        return null;
    }
}
