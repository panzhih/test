package com.testweb.DesignPatterns.BuilderPattern.wayTwo;

public class BuilderImpl extends Builder{
    Product product;

    BuilderImpl(){
        product = new Product();
    }

    @Override
    Builder builder1(String obj) {
        product.setBuilder1(obj);
        return this;
    }

    @Override
    Builder builder2(String obj) {
        product.setBuilder2(obj);
        return this;
    }

    @Override
    Builder builder3(String obj) {
        product.setBuilder3(obj);
        return this;
    }

    @Override
    Product getObject() {
        return product;
    }
}
