package com.wyq.springbootsecurityh2.controller;

import com.wyq.springbootsecurityh2.entity.User;
import com.wyq.springbootsecurityh2.respository.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author Mike
 * @Date 2019/1/24
 * @Version 1.0
 */
@Controller
public class MainController {

    @Resource
    private UserRespository userRespository;

    @RequestMapping("/")
    public String welcomePage() {
        return "redirect:main";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("welcome", userRespository.findAll());
        return "a";
    }


    @RequestMapping("/test")
    @ResponseBody
    public User testMethod(String name) {
        return userRespository.getOneByName(name);
    }


}
