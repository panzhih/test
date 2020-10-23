package com.testweb.otherTest;

import com.testweb.BasicTest.SerializableBean;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String url = new File("").getAbsolutePath()+"/test1.txt";
        SerializableBean serializableBean = new SerializableBean();
        serializableBean.setName("张三");
        serializableBean.setAge(15);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(url));
        writeObject(objectOutputStream,serializableBean);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(url));
        readObject(objectInputStream);
    }

    private static void writeObject(ObjectOutputStream objectOutputStream, SerializableBean serializableBean){
        try {
            objectOutputStream.writeObject(serializableBean);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        SerializableBean serializableBean = (SerializableBean)objectInputStream.readObject();
        System.out.println(serializableBean);
        objectInputStream.close();
    }
}
