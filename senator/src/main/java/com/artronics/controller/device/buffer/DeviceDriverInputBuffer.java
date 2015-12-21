package com.artronics.controller.device.buffer;

import java.util.List;

public interface DeviceDriverInputBuffer
{
    void sendBuffer(List<Integer> buffer);
}
