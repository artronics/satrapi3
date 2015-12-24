package com.artronics.senator.network.controller.sdwn.device.connection;


import com.artronics.senator.network.controller.sdwn.device.exception.DeviceConnectionException;

public interface Connection
{
    void open() throws DeviceConnectionException;

    void close();
}
