package com.testweb.DesignPatterns.FactoryPackage;

public class AbstractFactoryProduct2 implements NameInteface{
    @Override
    public Product getProduct() {
        return new Product2();
    }
}
