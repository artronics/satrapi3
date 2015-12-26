package com.artronics.senator.packet;

import com.artronics.senator.helper.FakeBufferFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SdwnPacketHelperTest
{

    private List<Integer> aBuff;
    private List<Integer> malformedPacket = new ArrayList<>();
    private FakeBufferFactory factory = new FakeBufferFactory();

    @Before
    public void setUp()
    {
        aBuff = FakeBufferFactory.createABuffer();
    }

    @Ignore("Validation for packet is deprecated")
    @Test
    public void Test_validation()
    {
        boolean isvalid = SdwnPacketHelper.validate(aBuff);
        assertTrue(isvalid);

        malformedPacket.add(2);//current validation just check the length(there is no more rule)
        assertFalse(SdwnPacketHelper.validate(malformedPacket));
    }

    @Test
    public void test_get_length()
    {
        assertEquals(aBuff.size(), SdwnPacketHelper.getLength(aBuff));
    }

    @Test
    public void Test_getType()
    {
        Packet.Type actType = Packet.Type.DATA;

        assertEquals(SdwnPacketHelper.getType(aBuff),actType);
    }

    @Test
    public void Test_getIntAddress_it_gets_two_int_and_returns_int()
    {
        int l = 10;
        int h = 0;
        int actMixed = SdwnPacketHelper.getIntAddress(l, h);
        int exp = 10;
        assertEquals(exp, actMixed);

        l = 0;
        exp = 0;
        actMixed = SdwnPacketHelper.getIntAddress(l, h);
        assertEquals(exp, actMixed);

        l = 4;
        h = 1;
        exp = 260; //256 +4
        actMixed = SdwnPacketHelper.getIntAddress(l, h);
        assertEquals(exp, actMixed);
    }

    @Test
    public void Test_splitAddress()
    {
        int[] exp = new int[]{0, 0};
        int[] act;
        act = SdwnPacketHelper.splitAddress(0);
        assertArrayEquals(exp, act);

        exp[0] = 1;
        exp[1] = 4;
        act = SdwnPacketHelper.splitAddress(260);
        assertArrayEquals(exp, act);

        exp[0] = 0;
        exp[1] = 30;
        act = SdwnPacketHelper.splitAddress(30);
        assertArrayEquals(exp, act);
    }

    @Test
    public void Test_joinAddresses()
    {
        int exp = 0;
        int act = SdwnPacketHelper.joinAddresses(0, 0);
        assertEquals(exp, act);

        exp = 30;
        act = SdwnPacketHelper.joinAddresses(0, 30);
        assertEquals(exp, act);

        exp = 260;
        act = SdwnPacketHelper.joinAddresses(1, 4);
        assertEquals(exp, act);
    }
}