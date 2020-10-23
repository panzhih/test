package com.testweb.otherTest;

import java.util.EnumMap;
import java.util.EnumSet;

public class RunThread {
    public static void main(String[] args){
        /*TestRunable testRunable = new TestRunable();
        for(int i = 0 ; i < 10 ; i++){
            new Thread(testRunable,"thread"+"--"+i).start();
        }*/


        SizeEnum[] sizeEnums =  SizeEnum.values();
        /*for(SizeEnum sizeEnum : sizeEnums){
            System.out.println(sizeEnum.toString());
        }*/

        EnumSet<SizeEnum> enumEnumSet = EnumSet.allOf(SizeEnum.class);
        for(SizeEnum sizeEnum : enumEnumSet){


        }

        EnumMap<SizeEnum,String> enumStringEnumMap = new EnumMap<SizeEnum, String>(SizeEnum.class);
        enumStringEnumMap.put(SizeEnum.RED,"红色");
        enumStringEnumMap.put(SizeEnum.BLANK,"黑色");
        enumStringEnumMap.put(SizeEnum.GREEN,"绿色");

        SizeEnum[] sizeEnums1 = SizeEnum.values();
        for(SizeEnum sizeEnum :sizeEnums1){
            System.out.println("[key=" + sizeEnum.name() + ",value="

                    + enumStringEnumMap.get(sizeEnum) + "]");
        }
    }
}
