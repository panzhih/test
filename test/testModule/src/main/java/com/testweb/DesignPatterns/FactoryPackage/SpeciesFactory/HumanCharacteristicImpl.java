package com.testweb.DesignPatterns.FactoryPackage.SpeciesFactory;

public class HumanCharacteristicImpl extends HumanCharacteristic{
    @Override
    public void getCharacteristic(){
        System.out.println("我是人类，我会说话");
    }
}
