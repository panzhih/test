package com.testweb.DesignPatterns.BuilderPattern.wayTwo;

public class Product {
    private String builder;

    private String builder1;

    private String builder2;

    private String builder3;

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getBuilder1() {
        return builder1;
    }

    public void setBuilder1(String builder1) {
        this.builder1 = builder1;
    }

    public String getBuilder2() {
        return builder2;
    }

    public void setBuilder2(String builder2) {
        this.builder2 = builder2;
    }

    public String getBuilder3() {
        return builder3;
    }

    public void setBuilder3(String builder3) {
        this.builder3 = builder3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "builder='" + builder + '\'' +
                ", builder1='" + builder1 + '\'' +
                ", builder2='" + builder2 + '\'' +
                ", builder3='" + builder3 + '\'' +
                '}';
    }
}
