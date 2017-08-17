package com.ziggle.controller;

import com.ziggle.dao.IUserRepository;
import com.ziggle.services.MongoDBJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello/*")
public class HelloController {


    @Autowired
    private IUserRepository userRepository;


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
}
