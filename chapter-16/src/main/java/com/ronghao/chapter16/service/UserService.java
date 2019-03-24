package com.ronghao.chapter16.service;

import com.ronghao.chapter16.entity.UserEntity;
import com.ronghao.chapter16.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:02 PM 3/19/2018
 * ==============================
 **********************************/
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

}
