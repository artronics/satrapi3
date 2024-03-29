package com.artronics.satrapi.core;

import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.services.SdwnNetworkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SatrapiInitializerImpl implements SatrapiInitializer
{
    private final static Logger log = Logger.getLogger(SatrapiInitializerImpl.class);

    private SdwnNetwork sdwnNetwork;

    @Value("${network.ip}")
    private String ip;

    @Autowired
    SdwnNetworkService networkService;

    @Autowired
    Seeder seeder;

    @Override
    public void initSdwnNetwork()
    {
        seeder.run();
        log.info("Initializing SDWN Network with IP: " + ip);
        sdwnNetwork = networkService.findByIp(ip);

        if (sdwnNetwork == null) {
            log.debug("There is no SDWN-Network on data base. Create on.");

            sdwnNetwork = new SdwnNetwork(ip);
            networkService.save(sdwnNetwork);
        }
    }
}
