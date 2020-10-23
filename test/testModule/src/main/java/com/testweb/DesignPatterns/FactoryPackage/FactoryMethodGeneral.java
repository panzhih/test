package com.testweb.DesignPatterns.FactoryPackage;

public class FactoryMethodGeneral {
    public static Product getProduct(String param){
        if("product1".equals(param)){
            return new Product1();
        }
        if("product2".equals(param)){
            return new Product2();
        }
        return null;
    }


    public static void main(String[] args){
        Product product = FactoryMethodGeneral.getProduct("product2");
        if(product != null){
            System.out.println(product.getName());
        }
    }
}
