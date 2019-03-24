package com.ronghao.chapter17.service;

import com.ronghao.chapter17.entity.UserEntity;
import com.ronghao.chapter17.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 12:18 PM 3/21/2018
 * ==============================
 **********************************/
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJPA.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("未查询到用户：" + username + "信息");
        }
        return user;
    }
}
