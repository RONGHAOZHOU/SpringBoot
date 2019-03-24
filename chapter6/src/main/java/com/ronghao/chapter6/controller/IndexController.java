package com.ronghao.chapter6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 1:20 AM 3/7/2018
 * ==============================
 **********************************/
@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
