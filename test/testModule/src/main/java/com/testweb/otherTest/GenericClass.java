package com.testweb.otherTest;

public class GenericClass {
    /*private static int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }*/

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        GenericClass.add(1, 2);
        GenericClass.add(1f, 2f);
        GenericClass.add(1d, 2d);
        GenericClass.add(Integer.valueOf(1), Integer.valueOf(2));
        GenericClass.add(Float.valueOf(1), Float.valueOf(2));
        GenericClass.add(Double.valueOf(1), Double.valueOf(2));
    }
}
