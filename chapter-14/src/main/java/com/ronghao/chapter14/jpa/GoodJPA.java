package com.ronghao.chapter14.jpa;

import com.ronghao.chapter14.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 10:12 PM 3/18/2018
 * ==============================
 **********************************/
public interface GoodJPA
        extends
        JpaRepository<GoodEntity,Long>,
        QueryDslPredicateExecutor<GoodEntity>{
}
