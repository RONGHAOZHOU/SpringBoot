package com.ronghao.lesson1.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWolrdController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        /**
         * @Author: RonghaoZhou                          
         * @Date: 2/24/2018 2:05 AM
         * @params: []
         * @return: java.lang.String
         **/
        return "HelloWolrd";
    }
}
