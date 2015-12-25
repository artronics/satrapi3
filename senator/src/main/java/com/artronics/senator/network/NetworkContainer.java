package com.artronics.senator.network;

import com.artronics.senator.network.config.NetworkBeanDef;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NetworkContainer
{

    private final static Logger log = Logger.getLogger(NetworkContainer.class);

    public static void main(String[] args){

        AnnotationConfigApplicationContext cnt = new AnnotationConfigApplicationContext(
                NetworkBeanDef.class);

    }
}
