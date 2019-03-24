package com.ronghao.chapter16.jpa;

import com.ronghao.chapter16.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:00 PM 3/19/2018
 * ==============================
 **********************************/
public interface UserJPA extends JpaRepository<UserEntity, Long> { }
