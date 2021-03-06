package com.ziggle.controller;

import com.ziggle.dao.IUserJpaRepository;
import com.ziggle.dao.IUserRepo;
import com.ziggle.entity.User;
import com.ziggle.services.MongoDBJDBC;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/hello/*")
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private IUserJpaRepository userJpaRepository;

    @Autowired
    IUserRepo userRepo;

    @RequestMapping("success")
    public String returnSuccess() {
        logger.error("hail hydra");
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

    @ResponseBody
    @RequestMapping(value = "findMyUser/{name}")
    public List<User> GetMyUser(@PathVariable("name") String name) {
        List<User> users = userRepo.findByName(name);
        return users;
    }

    @ResponseBody
    @RequestMapping(value = "findHeader")
    public void GetHeader(@RequestHeader("User-Agent") String ua, @RequestHeader("Cookie") String cookie) {
        System.out.println(ua);
        System.out.println(cookie);
    }


    @ResponseBody
    @RequestMapping(value = "findAll")
    public List<User> FindAllUser() {
        List<User> allUser = userRepo.findAll();
        return allUser;
    }
}
