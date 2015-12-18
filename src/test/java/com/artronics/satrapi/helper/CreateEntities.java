package com.artronics.satrapi.helper;

import com.artronics.satrapi.entities.SdwnController;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreateEntities
{
    private final static Logger log = Logger.getLogger(CreateEntities.class);

    private static List<SdwnController> createController(int num){
        List<SdwnController> controllers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            controllers.add(new SdwnController());
        }

        return controllers;
    }
}
