package com.testweb.DesignPatterns.PrototypePattern;

import org.junit.Test;

public class TestDemo implements Cloneable{
    private int n1 = 1;

    private int n2 = 2;

    private int n3 = 3;

    TestDemo(){
        n1 += 1;
        n2 += 1;
        n3 += 1;
    }

    public void change(){
        n1 = 3;
        n2 = 4;
        n3 = 5;
    }

    public TestDemo clone(){
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (TestDemo) obj;
    }

    public String toString(){
        return "n1="+n1+" n2="+n2+" n3="+n3;
    }


    public static void main(String[] args){
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo);

        TestDemo testDemo1 = testDemo.clone();
        System.out.println(testDemo1);

        testDemo.change();

        TestDemo testDemo2 = testDemo1.clone();
        System.out.println(testDemo2);


    }

}
