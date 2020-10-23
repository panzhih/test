package com.testweb.otherTest;

public enum SizeEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);

    private String name;
    private int size;

    SizeEnum(String name,int size){
        this.name = name;
        this.size = size;
    }

    // 普通方法
    public static String getName(int index) {
        for (SizeEnum c : SizeEnum.values()) {
            if (c.getSize() == index) {
                return c.name;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name+"--"+this.size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
