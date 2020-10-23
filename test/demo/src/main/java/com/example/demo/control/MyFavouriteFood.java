package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFavouriteFood {

    @RequestMapping("myFavouriteFood")
    public String text(){
        System.out.println("修改后的文件");
        System.out.println("再次修改");
        return "★My Favourite Food\n" +
                "I like many different kinds of foods, among them, egg is\n" +
                " my favorite. Egg contains a lot of\n" +
                " essential nutrients needed by the human body. Eggs are\n" +
                " oval shaped spheres with a light brown\n" +
                " color. Egg is the basic ingredient to many dishes, like\n" +
                " omelet and French toast. You can easily\n" +
                " get eggs at any supermarket, and they are sold for a\n" +
                " very cheap price too. Besides the cheap\n" +
                " price, egg contains lots of nutrients and is a very good\n" +
                " source of energy. In conclusion, egg is\n" +
                " my favorite food.";
    }
}
