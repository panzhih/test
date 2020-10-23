package com.example.demo.control;

import com.example.demo.commen.ADI;
import com.example.demo.jaxbUtil.JAXBUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBException;
import java.io.File;

@Controller
@RequestMapping(value = "jaxb")
public class JaxbController {

    @RequestMapping(value = "select",method = RequestMethod.GET)
    @ResponseBody
    public String selectXml(){
        System.out.println("我这里也修改");
        File file = new File(new File("").getAbsolutePath()+"/A1010242374.xml");
        ADI adi = null;
        try {
            adi = JAXBUtil.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Gson().toJson(adi);
    }

    @RequestMapping("myFavouriteFood")
    public String text(){
        return "★My Favourite Food" +
                " I like many different kinds of foods, among them, egg is my favorite." +
                " Egg contains a lot of essential nutrients needed by the human body." +
                " Eggs are oval shaped spheres with a light brown color." +
                " Egg is the basic ingredient to many dishes," +
                " like omelet and French toast." +
                " You can easily get eggs at any supermarket," +
                " and they are sold for a ery cheap price too." +
                " Besides the cheap price," +
                " egg contains lots of nutrients and is a very good source of energy." +
                " In conclusion, egg is my favorite food.";
    }

}
