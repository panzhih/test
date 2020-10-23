package com.testweb.DesignPatterns.FactoryPackage;

public class MoreFactoryMethod {
    public static Product getProduct(){
        return new Product1();
    }

    public static Product getProduct2(){
        return new Product2();
    }


    public static void main(String[] args){
        Product product = MoreFactoryMethod.getProduct();
        System.out.println(product.getName());
        System.out.println("---------");

        product = MoreFactoryMethod.getProduct2();
        System.out.println(product.getName());
    }
}

