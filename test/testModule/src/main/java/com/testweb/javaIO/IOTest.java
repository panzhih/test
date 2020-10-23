package com.testweb.javaIO;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class IOTest {

    //二进制数据的写入和读取(FileInputStream和FileOutputStream)
    @Test
    public void test1(){
        File file = new File(new File("").getAbsolutePath()+"/test1.txt");
        FileOutputStream fileOutputStream = null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[]{12,13,14,15};
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2(){
        try {
            FileInputStream inputStream = new FileInputStream(new File("").getAbsolutePath()+"/test1.txt");
            byte[] bytes = new byte[1024];
            int len ;
            while((len = inputStream.read(bytes)) != -1){
                System.out.println(len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //文件文件写入和读取
    @Test
    public void test3(){
        try {
            FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/test1.txt",false);
            fileWriter.append("初来学习java，请多关照");
            fileWriter.append("哈哈，java好好玩");
            fileWriter.append("再见java");
            System.out.println("编码为："+fileWriter.getEncoding());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try {
            FileReader fileReader = new FileReader(new File("").getAbsoluteFile()+"/test1.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String str = "";
            while ((str = reader.readLine()) != null){
                System.out.println(str);
            }
            fileReader.close();
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    /*
    * 键盘键入的两种方法
    *
    * */
    @Test
    public void test5() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please input char 'q' end");
        int s ;
        do{
            s = reader.read();
            //根据返回的ascii码去掉特殊操作符
            if(s > 31 && s != 127){
                System.out.println("input char is :"+(char)s);
                if((char)s == 'q'){
                    System.out.println("end");
                }
            }
        }while((char)s != 'q');
    }

    @Test
    public void test11(){
        Scanner scanner = new Scanner(System.in);
    }


    @Test
    public void test6() throws IOException, InterruptedException {
        for(int i = 0 ; i < 1000 ;i++){
            FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/test1.txt");
            int result;
            while ((result = fileInputStream.read()) != -1);
            Thread.sleep(1000L);
        }
        Thread.sleep(1000L);
    }





    @Test
    public void test7(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/test1.txt");
            FileDescriptor descriptor = fileInputStream.getFD();
            FileReader reader = new FileReader(descriptor);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String str ;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
            fileInputStream.close();
            reader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test8(){
        try {
            //FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/test1.txt",true);
            //FileDescriptor descriptor = fileOutputStream.getFD();
            FileWriter reader = new FileWriter(new File("").getAbsolutePath()+"/test1.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(reader);
            bufferedWriter.newLine();
            bufferedWriter.write("玩家1");
            bufferedWriter.newLine();
            //bufferedWriter.write('\n');
            bufferedWriter.write("缓冲1");
            //reader.write("大家好，哈哈，没有11");
            reader.flush();
            bufferedWriter.close();
            reader.close();

            System.out.println("");
            //fileOutputStream.close();
            //reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test9(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("").getAbsolutePath()+"/test1.txt"));
            int len ;
            while ((len = inputStreamReader.read()) != -1){
                System.out.print((char)len);
            }
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test10() throws IOException {
        InputStream buffered = new BufferedInputStream(new FileInputStream(new File("").getAbsolutePath()+"/test1.txt"),100);
        int len;
        while((len = buffered.read()) != -1){
            System.out.print((char)len);
        }
        buffered.close();
    }


    @Test
    public void test13() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(System.out);
        printStream.println("hahahah");
       // printStream.print("111");
        printStream.close();
    }

    @Test
    public void test14(){
        File file = new File("");
    }


}
