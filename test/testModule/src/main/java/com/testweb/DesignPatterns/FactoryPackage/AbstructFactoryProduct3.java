package com.testweb.DesignPatterns.FactoryPackage;

public class AbstructFactoryProduct3 implements NameInteface{
    @Override
    public Product getProduct() {
        return new Product3();
    }
}
