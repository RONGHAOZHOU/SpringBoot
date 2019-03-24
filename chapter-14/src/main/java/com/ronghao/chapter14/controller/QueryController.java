package com.ronghao.chapter14.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.ronghao.chapter14.entity.GoodEntity;
import com.ronghao.chapter14.entity.QGoodEntity;
import com.ronghao.chapter14.jpa.GoodJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 9:59 PM 3/18/2018
 * ==============================
 **********************************/
@RestController
public class QueryController {

    @Autowired
    private GoodJPA goodJPA;

    @PersistenceContext
    private EntityManager entityManager;


    @RequestMapping(value = "/query")
    public List<GoodEntity> list() {

        QGoodEntity _good=QGoodEntity.goodEntity;
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery
                .select(_good)
                .from(_good)
                .where(_good.type.id.eq(Long.valueOf("1")))
                .fetch();
    }

    @RequestMapping(value = "/join")
    public List<GoodEntity> join() {
        QGoodEntity _good = QGoodEntity.goodEntity;
        BooleanExpression expression = _good.type.id.eq(Long.valueOf("1"));
        Iterator<GoodEntity> iterator=goodJPA.findAll(expression).iterator();
        List<GoodEntity> goods = new ArrayList<>();
        while (iterator.hasNext()) {
            goods.add(iterator.next());
        }
        return goods;
    }
}
