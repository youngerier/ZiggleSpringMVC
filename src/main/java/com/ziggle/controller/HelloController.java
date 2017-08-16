package com.ziggle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello/*")
public class HelloController {

    @RequestMapping("success")
    public String returnSuccess() {
        return "views/success";
    }

    @ResponseBody
    @RequestMapping(value = "string", produces = "text/plain;charset=utf-8")
    public String returnString() {
        return "hello return string";
    }
}
