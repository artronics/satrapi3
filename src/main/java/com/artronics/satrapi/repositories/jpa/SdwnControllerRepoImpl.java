package com.artronics.satrapi.repositories.jpa;

import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.repositories.SdwnControllerCustomRepo;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SdwnNetworkRepo networkRepo;

    @Override
    public SdwnController findByNetwork(Long networkId, Long id)
    {
//        SdwnNetwork network = networkRepo.findOne(networkId);
//        SdwnController controller= em.find(SdwnController.class,id);
        throw new NotImplementedException();
    }
}
