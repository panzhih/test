package com.testweb.DesignPatterns.FactoryPackage;

import com.testweb.DesignPatterns.FactoryPackage.SpeciesFactory.SpeciesFactoryImpl;

public class TestController {

    public static void main(String[] args){
        NameInteface nameInteface = new AbstractFactoryMethod();
        Product product = nameInteface.getProduct();
        System.out.println(product.getName());
        System.out.println("==============");

        Product product1 = new AbstructFactoryProduct3().getProduct();
        System.out.println(product1.getName());
        System.out.println("---------------");

        //抽象工厂测试
        SpeciesFactoryImpl speciesFactory = new SpeciesFactoryImpl();
        speciesFactory.getAnimal().getCharacteristic();
        speciesFactory.getHuMan().getCharacteristic();
        speciesFactory.getPlant().getCharacteristic();
    }
}
