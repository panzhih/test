package com.testweb.DesignPatterns.FactoryPackage.SpeciesFactory;

public class AnimalCharacteristicImpl extends AnimalCharacteristic{
    @Override
    public void getCharacteristic(){
        System.out.println("我是动物，我不需要穿衣服");
    }
}
