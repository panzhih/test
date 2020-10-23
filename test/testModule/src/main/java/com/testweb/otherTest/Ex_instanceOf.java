package com.testweb.otherTest;

interface Man{}

class Person1 implements Man{}

/*
class Student extends Person1 {}
*/
class Postgraduate extends Student {}

class Animal {}

public class Ex_instanceOf
{
    public static void main(String[] args) {
        System.out.println("Student 的对象是谁的实例？");
        instanceofTest(new Student());
        System.out.println("Animal 的对象是谁的实例？");
        instanceofTest(new Animal());
        System.out.println("Postgraduate 的对象是谁的实例？");
        instanceofTest(new Postgraduate());
        System.out.println("persion 的对象是谁的实例？");
        instanceofTest(new Person1());

        System.out.println("对比字符串"+("ASDF" instanceof String));
        //一个类的实例是这个类本身的实例，也是他父类，父类的父类的实例，也是实现的接口的实例
    }
    public static void instanceofTest(Object p) {
        if (p instanceof Animal)
            System.out.println(p.getClass() + "类的实例  是类Animal的实例");
        if (p instanceof Postgraduate)
            System.out.println(p.getClass() + "类的实例  是类Postgraduate的实例");
        if (p instanceof Student)
            System.out.println(p.getClass() + "类的实例  是类Student的实例");
        if (p instanceof Person1)
            System.out.println(p.getClass() + "类的实例  是类Person的实例");
        if (p instanceof Man)
            System.out.println(p.getClass() + "类的实例  是接口Man的实例");
        if (p instanceof Object)
            System.out.println(p.getClass() + "类的实例  是类Object的实例");

    }
}