package com.testweb.DesignPatterns.BuilderPattern.wayOne;

public class BuilderImpl extends Builder{
    private Product product;

    BuilderImpl(){
        product = new Product();
    }
    @Override
    void builder1() {
        System.out.println("创建对象1");
    }

    @Override
    void builder2() {
        System.out.println("创建对象2");
    }

    @Override
    void builder3() {
        System.out.println("创建对象3");
    }

    @Override
    Product getObject() {
        System.out.println("获取对象");
        return product;
    }
}
