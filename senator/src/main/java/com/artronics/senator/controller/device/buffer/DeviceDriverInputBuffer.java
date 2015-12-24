package com.artronics.senator.controller.device.buffer;

import java.util.List;

public interface DeviceDriverInputBuffer
{
    void sendBuffer(List<Integer> buffer);
}
