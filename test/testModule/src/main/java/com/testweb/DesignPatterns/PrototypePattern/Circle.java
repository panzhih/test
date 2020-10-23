package com.testweb.DesignPatterns.PrototypePattern;

public class Circle extends Shape{

    public Circle(){
        type = "Cricle";
    }

    @Override
    void draw() {
        System.out.println("this is Circle create");
    }
}
