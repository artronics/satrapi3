package com.artronics.senator.satrapi.experiments;

import org.junit.Test;

public class PacketInheritanceTest
{
    @Test
    public void it_should(){
        Bar bar = new Bar("msg from bar");

    }
//    private Foo barIn(Bar in,String barMsg){
//        Foo f = new Foo(barMsg);
//    }
}
class FooModel{
    private String fooMsg;
    private String barMsg;
    Foo foo;
    public FooModel()
    {
    }

    public FooModel(Foo foo)
    {
        this.foo = foo;
    }

    public String getFooMsg()
    {
        return foo==null? fooMsg:foo.fooMsg;
    }

    public String getBarMsg()
    {
        return foo==null? barMsg:foo.barMsg;
    }
}
class Foo extends Bar{
    public Foo(String barMsg)
    {
        super(barMsg);
    }

    String fooMsg;
}
class Bar{
    String barMsg;

    public Bar(String barMsg)
    {
        this.barMsg = barMsg;
    }
}
