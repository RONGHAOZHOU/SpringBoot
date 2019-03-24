package com.ronghao.chapter12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 12:16 AM 3/15/2018
 * ==============================
 **********************************/
@RestController
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        logger.debug("this is a debug message!");
        logger.info("come to the index function!");
        logger.error("this is error message!");
        return "index";
    }


}
