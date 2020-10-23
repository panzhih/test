package com.testweb.DesignPatterns.SingletonPattern;


/**
 * 懒汉式，调用的时候生成对象
 */
public class SingletonPattern {

    //volatile作用：保证可见性，禁止jvm指令重排序，但不保证原子性
    private static volatile SingletonPattern singletonPattern;

    private SingletonPattern(){}

    public static SingletonPattern getInstance(){
        GetClass getClass = new GetClass();
        GetClass getClass1 = new GetClass();

        System.out.println("对象="+(getClass == getClass1));

        if(singletonPattern == null){
            synchronized (SingletonPattern.class){
                if(singletonPattern == null){
                    singletonPattern = new SingletonPattern();
                }
            }
        }
        return singletonPattern;
    }


    public void getValue(){
        System.out.println("成功返回==");
    }
}

/*
* 饿汉式。构建类的时候已经生成了对象
*/
class SingletonPattern1{
    private static SingletonPattern1 singletonPattern1 = new SingletonPattern1();
    private SingletonPattern1(){}

    public static SingletonPattern1 getInstance(){
        return singletonPattern1;
    }
}


/*
 *内部静态类
 * */
class StaticSingleton{

    private int count = 1;

    public static class NewSingleton{
       private static StaticSingleton staticSingleton = new StaticSingleton();

       public int getCount(){
           return 1;
       }
    }

    public static StaticSingleton getInstance(){
        System.out.println("创建对象");
        return NewSingleton.staticSingleton;
    }

    private StaticSingleton(){}

    public void setCount(int i){
        this.count = i;
    }

    public int getCount(){
        return count;
    }
}


class GetClass{
    static {
        System.out.println("我是静态方法");
    }

    public GetClass(){
        System.out.println("构造方法");
    }
    StaticSingleton staticSingleton = StaticSingleton.getInstance();

}

class Test {

    public static void main(String[] args){
        /*SingletonPattern simpleDateFormat;

        SingletonPattern simpleDateFormat1;
        for(int i=0;i<5;i++){
            final int n = 5;
            new Thread(){
                int m = 9;
                public void run(){
                    //SingletonPattern simpleDateFormat = SingletonPattern.getInstance();
                    //simpleDateFormat.getValue();
                    StaticSingleton staticSingleton = StaticSingleton.getInstance();
                    staticSingleton.setCount(m);
                    System.out.println("静态内部类实例化="+staticSingleton);
                }
            }.start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("回收");
        //System.gc();
        //Runtime.getRuntime().gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        SingletonPattern singletonPattern = SingletonPattern.getInstance();

        /*System.out.println();
        System.out.println("再次创建==");
        for(int i=0;i<5;i++){
            new Thread(){
                public void run(){
                    //SingletonPattern simpleDateFormat = SingletonPattern.getInstance();
                    //simpleDateFormat.getValue();
                    StaticSingleton staticSingleton = StaticSingleton.getInstance();
                    System.out.println("静态内部类实例化="+staticSingleton);
                }
            }.start();
        }
        //System.out.println("懒汉式对比返回=="+(simpleDateFormat == simpleDateFormat1));

        System.out.println("--------------");

        SingletonPattern1 singletonPattern1 = SingletonPattern1.getInstance();

        SingletonPattern1 singletonPattern11 = SingletonPattern1.getInstance();

        System.out.println("饿汉式对比返回="+(singletonPattern1 == singletonPattern11));*/


    }
}
