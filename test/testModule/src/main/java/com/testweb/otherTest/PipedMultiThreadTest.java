package com.testweb.otherTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedMultiThreadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            pis.connect(pos);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Producer p = new Producer(pos);
        Consumer c = new Consumer(pis);

        Thread tp1 = new Thread(p, "生产者1号");
        Thread tp2 = new Thread(p, "生产者2号");
        Thread tp3 = new Thread(p, "生产者3号");
        Thread tp4 = new Thread(p, "生产者4号");
        Thread tp5 = new Thread(p, "生产者5号");

        Thread tc1 = new Thread(c, "消费者1号");
        Thread tc2 = new Thread(c, "消费者2号");
        Thread tc3 = new Thread(c, "消费者3号");
        Thread tc4 = new Thread(c, "消费者4号");
        Thread tc5 = new Thread(c, "消费者5号");

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
        tp1.start();
        tp2.start();
        tc5.start();
        tp3.start();
        tp4.start();
        tp5.start();
    }

    private static class Producer implements Runnable {
        private PipedOutputStream pos;

        public Producer(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    pos.write(("threadName="+Thread.currentThread().getName()+", messageId=" + i + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {
        private PipedInputStream pis;

        public Consumer(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            int len = -1;
            byte[] buffer = new byte[1024];
            try {
                //read(buffer, 0, buffer.length)函数作用有两个：
                //(1)若有buffer.length个数据可读，则返回buffer.length个数据；
                //   否则读取当前可读的所有数据，个数小于buffer.length;
                //(2)若没有数据可读，则让读进程等待(见read()函数)
                while ((len = pis.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}