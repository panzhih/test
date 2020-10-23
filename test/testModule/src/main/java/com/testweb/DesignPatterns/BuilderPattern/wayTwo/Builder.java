package com.testweb.DesignPatterns.BuilderPattern.wayTwo;

abstract class Builder {
    abstract Builder builder1(String obj);

    abstract Builder builder2(String obj);

    abstract Builder builder3(String obj);


    abstract Product getObject();
}
