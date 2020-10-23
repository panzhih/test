package com.testweb.BasicTest;
/*
*
*测试类对象重复创建
*/
public class ClassObject {
    public static void main(String[] args){

        Bread bread1 = new Bread();
        Bread bread2 = new Bread();


        System.out.println(Bread.getName());
    }
}


class Bread {
    static{
        System.out.println("Bread is loaded");
    }
    public Bread() {
        System.out.println("bread");
    }

    static String getName(){
        return "哈哈哈";
    }

    Red red = new Red();
}

class Red{
    static {
        System.out.println("my is red");
    }
}
