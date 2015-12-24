package com.artronics.controller.device.connection;


import com.artronics.controller.device.exception.DeviceConnectionException;

public interface Connection<C>
{
    void open() throws DeviceConnectionException;

    void close();
}
