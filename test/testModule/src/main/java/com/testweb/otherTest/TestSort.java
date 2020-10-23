package com.testweb.otherTest;

import java.util.*;

public class TestSort {

    public static void main(String[] args){
        List<String> times = new ArrayList<>();
        times.add("2020-04-24 11:38:00");
        times.add("2019-04-24 10:14:00");
        times.add("2020-03-24 10:23:00");
        times.add("2020-02-02 10:23:00");
        TestSort testSort = new TestSort();
        testSort.sort(times);
        System.out.println(times);

        long dickKey = new Date().getTime();
        System.out.println(dickKey);
        int id = Integer.valueOf(String.valueOf(dickKey).substring(4));
        System.out.println(id);


    }

    public void sort(List<String> times) {
        //实现排序方法
        Collections.sort(times, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                if (str1.compareToIgnoreCase(str2) < 0) {
                    return -1;
                }
                return 1;
            }
        });
    }
}
