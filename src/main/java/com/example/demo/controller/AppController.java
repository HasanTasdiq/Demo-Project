package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    @ResponseBody
    @RequestMapping("/home")
    public String hello()
    {
        return "helllo";
    }
    @RequestMapping("/welcome")
    public String Welcome()
    {
        return "login";
    }





}
