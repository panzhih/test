package com.testweb.DesignPatterns.BuilderPattern.wayTwo;

public class TestClass {

    public static void main(String[] args){
        /*BuilderImpl builder = new BuilderImpl();
        Product product = builder.builder1("对象1").builder2("对象2").builder3("对象3").getObject();
        System.out.println(product.toString());*/


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("对象qq");
        System.out.println(stringBuffer);
    }
}
