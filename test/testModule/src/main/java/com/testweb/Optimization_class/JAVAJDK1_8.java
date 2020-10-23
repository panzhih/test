package com.testweb.Optimization_class;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * java1.8新特性测试
 */

public class JAVAJDK1_8 {
    //比较器
    Comparator<Integer> cpt = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    };

    //Lambda表达式
    Comparator<Integer> lam = (x,y) -> Integer.compare(x,y);

    //优化内容，比如这种代码重复的
    /*public  List<Product> filterProductByColor(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if ("红色".equals(product.getColor())){
                prods.add(product);
            }
        }
        return prods;
    }

    public  List<Product> filterProductByPrice(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if (product.getPrice() < 8000){
                prods.add(product);
            }
        }
        return prods;
    }*/

    //过滤方法
    public List<Product> filterProductByPredicate(List<Product> list, CommomInteger<Product> mp){
        List<Product> prods = new ArrayList<>();
        for (Product prod : list){
            if (mp.MyFlag(prod)){
                prods.add(prod);
            }
        }
        return prods;
    }

    //使用内部类的方式优化
    public void test(){
        filterProductByPredicate(null, new CommomInteger<Product>() {
            @Override
            public boolean MyFlag(Product product) {
                return product.getPlace() <80000;
            }
        });

    }

    @Test
    //使用Lambda表达式优化简化代码
    public void test4(){
        List<Product> ll = new LinkedList<>();
        Product product = new Product();
        product.setPlace(3000L);
        Product product1 = new Product();
        product1.setPlace(9000L);
        Product product2 = new Product();
        product2.setPlace(10000L);
        Product product3= new Product();
        product3.setPlace(5000L);

        ll.add(product);
        ll.add(product1);
        ll.add(product2);
        ll.add(product3);
        System.out.println("设置前===");
        for(Product product4 :ll){
            System.out.print(product4.getPlace()+" ");
        }
        System.out.println();
        List<Product> lists = filterProductByPredicate(ll,(x) -> x.getPlace() < 8000);
        System.out.println("设置后===");
        for(Product product4 : lists){
            System.out.print(product4.getPlace()+" ");
        }
        System.out.println();
        //ll.stream().filter((p) -> p.getPlace() < 4000).forEach(System.out.println(););
        System.out.println("再次过滤===");
        lists.stream().filter((p) -> p.getPlace() < 4000).map(Product::getPlace)
                .forEach(System.out::println);

    }







}
