package com.testweb.BeanLifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object arg, String arg0)
            throws BeansException {
        System.out
                .println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg, String arg0)
            throws BeansException {
        System.out
                .println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg;
    }
}
