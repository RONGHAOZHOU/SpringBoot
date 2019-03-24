package com.ronghao.chapter16.controller;

import com.ronghao.chapter16.entity.UserEntity;
import com.ronghao.chapter16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:07 PM 3/19/2018
 * ==============================
 **********************************/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userService.list();
    }

}
