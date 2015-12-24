package com.artronics.senator.satrapi.repositories.jpa;

import com.artronics.senator.satrapi.entities.SdwnController;
import com.artronics.senator.satrapi.entities.SdwnNetwork;
import com.artronics.senator.satrapi.repositories.SdwnControllerCustomRepo;
import com.artronics.senator.satrapi.repositories.SdwnNetworkRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
        SdwnNetwork network = networkRepo.findOne(networkId);
        if (network == null) {
            return null;
        }

        List<SdwnController> controllers = network.getControllers();

        for (SdwnController controller:controllers ){
            if (controller.getId().equals(id))
                return controller;
        }

        return null;
    }
}
