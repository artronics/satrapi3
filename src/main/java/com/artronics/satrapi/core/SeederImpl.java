package com.artronics.satrapi.core;

import com.artronics.satrapi.entities.DeviceConnection;
import com.artronics.satrapi.entities.SdwnController;
import com.artronics.satrapi.entities.SdwnNetwork;
import com.artronics.satrapi.repositories.DeviceConnectionRepo;
import com.artronics.satrapi.repositories.SdwnControllerRepo;
import com.artronics.satrapi.repositories.SdwnNetworkRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SeederImpl implements Seeder
{
    private final static Logger log = Logger.getLogger(SeederImpl.class);

    @Value("${network.ip}")
    private String ip;

    @Autowired
    SdwnNetworkRepo networkRepo;

    @Autowired
    SdwnControllerRepo controllerRepo;

    @Autowired
    DeviceConnectionRepo connectionRepo;

    @Override
    public void run(){
        log.debug("Seeder ...");

        createNetwork();
    }

    private void createNetwork()
    {
        SdwnNetwork net = new SdwnNetwork(ip);

        SdwnController ctrl = new SdwnController();
        ctrl.setDescription("This is a controller created by seeder mainly for test purposes");
        ctrl.setSdwnNetwork(net);
        ctrl.setSinkAddress(0L);

        DeviceConnection dev = new DeviceConnection();
        dev.setSdwnController(ctrl);
        dev.setConnectionString("/dev/tty.usbserial-AH00WG8Y");

        connectionRepo.save(dev);

        log.debug("create a network with one controller and a device connection");
    }

}
