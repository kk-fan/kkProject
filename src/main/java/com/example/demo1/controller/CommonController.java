package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: kkfan
 * @Date: 2019/1/8 19:25
 * @Description:
 */
@Controller
public class CommonController extends BaseController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
