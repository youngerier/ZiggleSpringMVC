package com.ziggle.controller;

import com.ziggle.dao.IUserJpaRepository;
import com.ziggle.modules.User;
import com.ziggle.services.MongoDBJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/hello/*")
public class HelloController {


    @Autowired
    private IUserJpaRepository userJpaRepository;


    @RequestMapping("success")
    public String returnSuccess() {
        return "views/success";
    }

    @ResponseBody
    @RequestMapping(value = "string", produces = "text/plain;charset=utf-8")
    public String returnString() {
        return "hello return string";
    }


    public void TestServices() {
        MongoDBJDBC d = new MongoDBJDBC();
        d.GetClient();
    }

    @ResponseBody
    @RequestMapping(value = "findUser/{id}")
    public User GetUser(@PathVariable("id") long id) {
        User users = userJpaRepository.findOne(id);
        return users;
    }
}
