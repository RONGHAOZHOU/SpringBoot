package com.ronghao.chapter8.controller;

import com.alibaba.fastjson.JSONObject;
import com.ronghao.chapter8.utils.LoggerUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 6:05 PM 3/11/2018
 * ==============================
 **********************************/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public JSONObject login(HttpServletRequest request, String name) {
        JSONObject object = new JSONObject();
        object.put("msg", "user" + name + ",login successful!");
        request.setAttribute(LoggerUtils.LOGGER_RETURN,object);
        return object;
    }
}
