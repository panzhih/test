package com.testweb.GCTest;

import sun.misc.GC;

public class GCCycleTest {

    public static void main(String[] args){
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();

        myObject1.object = myObject2;

        myObject2.object = myObject1;

        myObject1 = null;

        myObject2 = null;

    }
}


class MyObject {
    public Object object = null;
}
