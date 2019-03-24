package com.ronghao.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 12:11 PM 3/15/2018
 * ==============================
 **********************************/
@Controller
public class TestController {
    private static final Logger logger= LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(){
        logger.info("test function");
        logger.error("error information");
        return "index";
    }
}
