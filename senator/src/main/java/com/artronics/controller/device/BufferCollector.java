package com.artronics.controller.device;

import java.util.List;

public interface BufferCollector
{
    int START_BYTE = 122;
    int STOP_BYTE = 126;

    List<List<Integer>> generateLists(List<Integer> receivedData);
}
