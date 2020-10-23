package com.testweb.DesignPatterns.FactoryPackage.SpeciesFactory;
/*
* 物种抽象工厂
*/
public abstract class SpeciesFactory {
    //人类
    public abstract Characteristic getHuMan();

    //动物
    public abstract Characteristic getAnimal();

    //植物
    public abstract Characteristic getPlant();

}
