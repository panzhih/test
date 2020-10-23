package com.testweb.DesignPatterns.BuilderPattern.wayOne;

public class Director {

    public Product createObject(Builder builder){
        builder.builder1();
        builder.builder2();
        builder.builder3();
        return builder.getObject();
    }


    public static void main(String[] args){
        Director director = new Director();
        Product product = director.createObject(new BuilderImpl());
        System.out.println(product.toString());
    }
}
