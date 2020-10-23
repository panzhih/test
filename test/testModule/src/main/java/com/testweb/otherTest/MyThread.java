package com.testweb.otherTest;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {
    private Random random = null;

    public MyThread() {
        random = new Random();
    }
    @Override
    public void run() {
        try {
            //System.out.println("任务执行开始:" + new Date());
            /**使用随机延时[0-3]秒来模拟执行任务*/
            //int sleepNumber = random.nextInt(3);
            //TimeUnit.SECONDS.sleep(sleepNumber);
            System.out.println(new Date()+"任务执行完毕:" + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        /**使用Executors工具快速构建对象*/
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        //System.out.println("3秒后开始执行计划线程池服务..." + new Date());
        //scheduledExecutorService.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        //scheduledExecutorService.schedule(new MyThread(), 10, TimeUnit.SECONDS);

        for(int i=3 ; i< 50 ;i++){
            System.out.println("创建线程=="+i);
            scheduledExecutorService.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        }
    }
}