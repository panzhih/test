package com.testweb.otherTest;

/**
 * 进栈，出栈，最小值
 */
public class StackTest {
    public static void main(String[] args) {
        System.out.println("服务商==");
        System.out.println("用户商");
        //Stack<Integer> stack = new Stack<>();
        //
        //sum(3);

    }

    public static void demo(){}


    public static void sum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            int n = 1;
            for (int j = 1; j <= i; j++) {
                n = n * j;
            }
            sum = sum + n;
        }
        System.out.println("1！+2！+3！+……+"+num+"！="+sum);
    }
}
