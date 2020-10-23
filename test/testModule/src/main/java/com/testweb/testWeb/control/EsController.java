package com.testweb.testWeb.control;

import com.testweb.testWeb.bean.Book;
import com.testweb.testWeb.repository.MonitorAlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "es")
public class EsController {

    @Autowired
    private MonitorAlarmRepository repository;



    @RequestMapping(value = "save")
    @ResponseBody
    public String save(@RequestParam(value = "name") String name,
                       @RequestParam(value = "id") int id){
        Book book = new Book();
        book.setContent("save");
        book.setId(id);
        book.setName(name);
        Book book1 = this.repository.save(book);

        return book1.toString();
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(){
        return "update";
    }

    @RequestMapping(value = "select")
    @ResponseBody
    public String select(){

        return "select";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id") int id){
        /*Optional book = this.repository.findById(Long.valueOf(id));
        book.
        this.repository.delete(id);*/
        return "delete";
    }
}
