package com.artronics.satrapi.experiments;

import org.junit.Test;

public class DecoratorTest
{
    @Test
    public void it()
    {
        DevPck devPck = devIn("dev content");
        CtrlPck ctrlPck = ctrlIn(devPck,"con id");
        NetPck netPck = netIn(ctrlPck,"net ip");


    }

    private DevPck devIn(String msg)
    {
        return new DevPck(msg);
    }

    private CtrlPck ctrlIn(DevPck in,String id)
    {
        CtrlPck c = new CtrlPck(in);
        c.setCtrlMsg(id);
        return c;
    }

    private NetPck netIn(CtrlPck in,String ip){
        NetPck n = new NetPck(in);
        n.setNetMsg(ip);
        return n;
    }

}

interface Pck
{
    String getDesc();
}

class Decorator implements Pck
{
    final Pck pck;
    private String netId;

    public Decorator(Pck pck)
    {
        this.pck = pck;
    }

    public String getNetId()
    {
        return netId;
    }

    public void setNetId(String netId)
    {
        this.netId = netId;
    }

    @Override
    public String getDesc()
    {
        return null;
    }
}

class DevPck implements Pck
{
    String devMsg;

    public DevPck(String devMsg)
    {
        this.devMsg = devMsg;
    }

    @Override
    public String getDesc()
    {
        return "base";
    }

    public String getDevMsg()
    {
        return devMsg;
    }

    public void setDevMsg(String devMsg)
    {
        this.devMsg = devMsg;
    }
}

class CtrlPck extends Decorator
{
    String ctrlMsg;
    String netId;

    public CtrlPck(Pck pck)
    {
        super(pck);
    }

    @Override
    public String getNetId()
    {
        return this.netId;
    }

    @Override
    public void setNetId(String netId)
    {
        this.netId=netId;
    }

    public String getCtrlMsg()
    {
        return ctrlMsg;
    }

    public void setCtrlMsg(String ctrlMsg)
    {
        this.ctrlMsg = ctrlMsg;
    }
}

class NetPck extends Decorator
{
    String netMsg;

    public NetPck(Pck pck)
    {
        super(pck);
    }

    public String getNetMsg()
    {
        return netMsg;
    }

    public void setNetMsg(String netMsg)
    {
        this.netMsg = netMsg;
    }
}
