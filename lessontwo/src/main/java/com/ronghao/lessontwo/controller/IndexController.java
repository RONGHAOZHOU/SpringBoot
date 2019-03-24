package com.ronghao.lessontwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:11 PM 2/28/2018
 * ==============================
 **********************************/
@Controller
public class IndexController {
    /**
     * @author: RonghaoZhou                          
     * @date:  2/28/2018 
     * @params: 
     * @return: 
     **/
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
