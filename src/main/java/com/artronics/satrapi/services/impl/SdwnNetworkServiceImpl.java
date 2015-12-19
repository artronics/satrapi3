package com.artronics.satrapi.services.impl;

import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import com.artronics.satrapi.services.SdwnNetworkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SdwnNetworkServiceImpl implements SdwnNetworkService
{
    private final static Logger log = Logger.getLogger(SdwnNetworkServiceImpl.class);

    @Autowired
    private SdwnNetworkRepo networkRepo;

    @Override
    public SdwnNetwork save(SdwnNetwork network)
    {
        return networkRepo.save(network);
    }

    @Override
    public SdwnNetwork findByIp(String ip)
    {
        return networkRepo.findByIp(ip);
    }
}
