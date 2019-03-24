package com.ronghao.lessonthree.jpa;

import com.ronghao.lessonthree.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 3:40 PM 3/3/2018
 * ==============================
 **********************************/
public interface UserJPA extends JpaRepository<UserEntity,Long> ,JpaSpecificationExecutor<UserEntity>,Serializable{
}
