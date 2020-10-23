package com.testweb.otherTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 时间比较测试
 */
public class TimesCompare {

    public void compare1(List<String> times){
        Collections.sort(times, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
    }

    public void compare2(List<String> times){
        Collections.sort(times,(str1,str2) -> str1.compareToIgnoreCase(str2));
    }

    public static void main(String[] args){
        List<String> time1 = new ArrayList<>();
        time1.add("2019-09-10 10:00:00");
        time1.add("2019-09-10 10:00:00");
        time1.add("2019-12-10 10:00:00");
        time1.add("2020-09-10 00:00:00");

        //方法1调用比较
        new TimesCompare().compare1(time1);
        System.out.println("方法1比较结果="+time1);

        List<String> time2 = new ArrayList<>();
        time2.add("2020-01-01 00:00:00");
        time2.add("2019-11-10 10:00:00");
        time2.add("2019-12-10 10:00:00");
        time2.add("2019-11-10 10:00:00");

        //方法2调用比较
        new TimesCompare().compare2(time2);
        System.out.println("方法2比较结果="+time2);

    }
}
