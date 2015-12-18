package com.artronics.satrapi.repositories.jpa;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.repositories.SdwnControllerCustomRepo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SdwnControllerRepoImpl implements SdwnControllerCustomRepo
{
    private final static Logger log = Logger.getLogger(SdwnControllerRepoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public SdwnController findByNetwork(Long networkId, Long id)
    {
        throw new NotImplementedException();
    }
}
