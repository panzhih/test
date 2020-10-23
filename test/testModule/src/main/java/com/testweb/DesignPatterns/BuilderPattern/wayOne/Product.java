package com.testweb.DesignPatterns.BuilderPattern.wayOne;

public class Product {
    private String builder1;
    private String builder2;
    private String builder3;
    private String builder4;

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

    public String getBuilder4() {
        return builder4;
    }

    public void setBuilder4(String builder4) {
        this.builder4 = builder4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "builder1='" + builder1 + '\'' +
                ", builder2='" + builder2 + '\'' +
                ", builder3='" + builder3 + '\'' +
                ", builder4='" + builder4 + '\'' +
                '}';
    }
}
