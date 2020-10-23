package com.testweb.otherTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaClassTest {
    public int a;
    private int b;
    private String cString;
    public String name;
    protected String dString;
    int d;
    public JavaClassTest() {
        System.out.println("构造方法");
    }
    private JavaClassTest(int a) {
        System.out.println("私有的构造方法"+a);
    }
    public JavaClassTest(int a,int b) {
        System.out.println("构造方法两个参数");
    }
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }
    @Override
    public String toString() {
        return "Test01 [a=" + a + ", b=" + b + ", cString=" + cString + ", name=" + name + ", dString=" + dString
                + ", d=" + d + "]";
    }
    public static void main(String[] args) throws Exception{
        Class<?> class1 = Class.forName("otherTest.JavaClassTest");

        //获取对象
        Object newInstance2 = class1.getConstructor().newInstance();

        System.out.println("------------------获取构造方法并使用-----------------------------------");
        Constructor<?>[] constructors = class1.getConstructors();
        for(Constructor aConstructor :constructors) {
            System.out.println(aConstructor);
        }
        System.out.println("---------------------------------------------------------------------------");
        constructors = class1.getDeclaredConstructors();
        for(Constructor constructor: constructors) {
            System.out.println(constructor);
        }
        System.out.println("---------------------------------------------------------------------------");
        Constructor<?> declaredConstructor = class1.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);
        //declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance(1);
        System.out.println("--------------------获取成员变量并调用----------------------------------------");
        Field[] fields = class1.getFields();
        for(Field f:fields) {
            System.out.println(f);
        }
        System.out.println("---------------------------------------------------------------------------");
        Field[] declaredFields = class1.getDeclaredFields();
        for(Field field :declaredFields) {
            System.out.println(field);
        }
        Field field = class1.getField("name");
        field.set(newInstance2, "hjsjy");
        System.out.println(field);
        JavaClassTest test01=(JavaClassTest)newInstance2;
        System.out.println(test01.name);
        System.out.println("---------------------------------------------------------------------------");
        Field declaredField = class1.getDeclaredField("b");
        System.out.println(declaredField);
        declaredField.setAccessible(true);
        declaredField.set(newInstance2, 188);
        System.out.println(newInstance2);
        System.out.println("-------------------------获取方法并掉调用-----------------------------------");
        Method[] methods = class1.getMethods();
        for(Method method:methods) {
            System.out.println(method);
        }
        Method[] declaredMethods = class1.getDeclaredMethods();
        for(Method method: declaredMethods) {
            System.out.println(method);
        }
        Method method = class1.getDeclaredMethod("show4", int.class);
        System.out.println(method);
        //Object newInstance3 = class1.getConstructor().newInstance();
        method.invoke(newInstance2, 1000);
        Method declaredMethod = class1.getDeclaredMethod("show4", int.class);
        System.out.println(declaredMethod);
        //declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(newInstance2, 500);
        System.out.println(invoke);

        Method show3M = class1.getDeclaredMethod("show3");
        show3M.invoke(newInstance2);

    }
}
