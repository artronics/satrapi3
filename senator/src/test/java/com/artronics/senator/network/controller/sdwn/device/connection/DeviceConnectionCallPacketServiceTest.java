package com.artronics.senator.network.controller.sdwn.device.connection;

import com.artronics.senator.event.DeviceInputBufferIsReady;
import com.artronics.senator.network.controller.sdwn.device.DeviceConnectionServiceImpl;
import com.artronics.senator.network.controller.sdwn.device.buffer.BufferCollector;
import com.artronics.senator.packet.services.PacketService;
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

public class DeviceConnectionCallPacketServiceTest
{
    @InjectMocks
    @Spy
    private DeviceConnectionServiceImpl connectionService;

    @Mock
    private BufferCollector bufferCollector;

    @Mock
    private PacketService packetService;

    private List<Integer> buffer = new ArrayList<>();
    private List<List<Integer>> buffers = new ArrayList<>();

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void when_buffer_received_it_should_call_collector(){
        fireDeviceInputBufferIsReady(buffer);

        verify(bufferCollector,times(1)).generateLists(buffer);
    }

    @Test
    public void if_BC_returns_empty_list_should_not_call_packet_service(){
        fireDeviceInputBufferIsReady(buffer);
        when(bufferCollector.generateLists(buffer)).thenReturn(new ArrayList<List<Integer>>());

        verify(bufferCollector,times(1)).generateLists(buffer);
        verify(packetService,times(0)).addBuffer(any());
        verifyNoMoreInteractions(bufferCollector);
    }

    @Test
    public void as_long_as_there_is_buffer_we_should_fire_event(){
        buffers=createLists(5);
        when(bufferCollector.generateLists(buffer)).thenReturn(buffers);
        fireDeviceInputBufferIsReady(buffer);

        verify(bufferCollector,times(1)).generateLists(buffer);
        verify(packetService,times(5)).addBuffer(any());
    }

    private List<List<Integer>> createLists(int num){
        List<List<Integer>> lists= new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lists.add(new ArrayList<>());
        }

        return lists;
    }

    private void fireDeviceInputBufferIsReady(List<Integer> buffer){
        DeviceInputBufferIsReady event = new DeviceInputBufferIsReady(this,buffer);
        connectionService.deviceInputBufferIsReadyHandler(event);
    }
}