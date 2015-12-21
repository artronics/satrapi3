package com.artronics.controller.device;

import com.artronics.controller.device.buffer.BufferCollector;
import com.artronics.controller.device.buffer.DeviceDriverInputBufferImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class DeviceDriverInputBufferImplTest
{
    @InjectMocks
    @Spy
    private DeviceDriverInputBufferImpl deviceDriver;

    @Mock
    private BufferCollector bufferCollector;

    private List<Integer> buffer = new ArrayList<>();
    private List<List<Integer>> buffers = new ArrayList<>();

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void when_call_send_buffer_bufferCollector_must_be_called(){
        deviceDriver.sendBuffer(buffer);
        verify(bufferCollector,times(1)).generateLists(buffer);
    }

    @Test
    public void if_BC_returns_empty_list_shouldnt_fire_event(){
        deviceDriver.sendBuffer(buffer);
        when(bufferCollector.generateLists(buffer)).thenReturn(new ArrayList<List<Integer>>());

        verify(bufferCollector,times(1)).generateLists(buffer);
        verify(deviceDriver,times(0)).fireDeviceBufferIsReady(any());
        verifyNoMoreInteractions(bufferCollector);
    }

    @Test
    public void as_long_as_there_is_buffer_we_should_fire_event(){
        buffers=createLists(5);
        when(bufferCollector.generateLists(buffer)).thenReturn(buffers);
        deviceDriver.sendBuffer(buffer);

        verify(bufferCollector,times(1)).generateLists(buffer);
        verify(deviceDriver,times(5)).fireDeviceBufferIsReady(any());
    }

    private List<List<Integer>> createLists(int num){
        List<List<Integer>> lists= new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lists.add(new ArrayList<>());
        }

        return lists;
    }
}