package com.testweb.DesignPatterns.BuilderPattern.wayOne;

abstract class Builder {
    //构建对象过程
    abstract void builder1();

    abstract void builder2();

    abstract void builder3();

    abstract Product getObject();

}
