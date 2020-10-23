package com.testweb.testWeb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControl {

    @RequestMapping(value = "testWeb")
    //@ResponseBody
    public String test(){
        System.out.println("ceshi");
        return "test";
    }
}
