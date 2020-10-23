package com.testweb.otherTest;

public class TestRunable implements Runnable{

    private int count = 10;

    public void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + "=="+count);
    }
}
