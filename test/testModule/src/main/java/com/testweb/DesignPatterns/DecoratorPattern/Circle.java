package com.testweb.DesignPatterns.DecoratorPattern;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("circleDraw()");
    }
}
