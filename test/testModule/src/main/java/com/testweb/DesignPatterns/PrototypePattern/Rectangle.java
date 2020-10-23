package com.testweb.DesignPatterns.PrototypePattern;

public class Rectangle extends Shape{

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("this is Rectangle create");
    }
}
