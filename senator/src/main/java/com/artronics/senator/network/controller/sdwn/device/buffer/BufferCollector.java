package com.artronics.senator.network.controller.sdwn.device.buffer;

import java.util.List;

public interface BufferCollector
{
    List<List<Integer>> generateLists(List<Integer> receivedData);
}
