package com.testweb.DesignPatterns.ProxyPattern;

public class RealImage implements Image{
    private String fileName;

    RealImage(String name){
        this.fileName = name;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("dispay images");
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
