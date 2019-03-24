package com.ronghao.chapter13.jpa;

import com.ronghao.chapter13.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 9:22 PM 3/16/2018
 * ==============================
 **********************************/
@Transactional
public interface UserJPA extends JpaRepository<UserEntity,Long> {
    @Query(value = "select * from t_user where t_age > ?1" ,nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 ", nativeQuery = true)
    public void deleteByName(String name);
}
