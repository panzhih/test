package com.testweb.DesignPatterns.FactoryPackage.SpeciesFactory;

public class SpeciesFactoryImpl extends SpeciesFactory{
    @Override
    public Characteristic getHuMan() {
        return new HumanCharacteristicImpl();
    }

    @Override
    public Characteristic getAnimal() {
        return new AnimalCharacteristicImpl();
    }

    @Override
    public Characteristic getPlant() {
        return new PlantCharacteristicImpl();
    }
}
