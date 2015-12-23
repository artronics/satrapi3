package com.artronics.event;

import java.util.List;

public class DeviceInputBufferIsReady extends BaseEvent<List<Integer>>
{
    public DeviceInputBufferIsReady(Object source, List<Integer> message)
    {
        super(source, message);
    }
}
