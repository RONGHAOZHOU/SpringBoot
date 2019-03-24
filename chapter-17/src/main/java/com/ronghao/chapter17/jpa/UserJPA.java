package com.ronghao.chapter17.jpa;

import com.ronghao.chapter17.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 12:15 PM 3/21/2018
 * ==============================
 **********************************/
public interface UserJPA extends JpaRepository<UserEntity, Long> {
    public UserEntity findByUsername(String username);
}
