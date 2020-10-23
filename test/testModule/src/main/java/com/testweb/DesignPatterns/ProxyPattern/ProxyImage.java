package com.testweb.DesignPatterns.ProxyPattern;

public class ProxyImage implements Image{
    private String fileName;

    private RealImage realImage;

    ProxyImage(String name){
        this.fileName = name;
    }


    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
