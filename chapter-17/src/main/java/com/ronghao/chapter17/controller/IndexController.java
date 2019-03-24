package com.ronghao.chapter17.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 12:47 PM 3/21/2018
 * ==============================
 **********************************/
@RestController
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        return "get index success";
    }
}
