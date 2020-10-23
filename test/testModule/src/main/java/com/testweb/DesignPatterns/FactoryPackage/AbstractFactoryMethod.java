package com.testweb.DesignPatterns.FactoryPackage;

public class AbstractFactoryMethod implements NameInteface{
    @Override
    public Product getProduct() {
        return new Product1();
    }
}
