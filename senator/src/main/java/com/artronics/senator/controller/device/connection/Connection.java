package com.artronics.senator.controller.device.connection;


import com.artronics.senator.controller.device.exception.DeviceConnectionException;

public interface Connection
{
    void open() throws DeviceConnectionException;

    void close();
}
