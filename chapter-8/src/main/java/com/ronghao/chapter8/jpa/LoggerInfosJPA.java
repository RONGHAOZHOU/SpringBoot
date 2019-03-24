package com.ronghao.chapter8.jpa;

import com.ronghao.chapter8.entity.TLoggerInfos;
import org.springframework.data.jpa.repository.JpaRepository;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 4:07 PM 3/11/2018
 * ==============================
 **********************************/
public interface LoggerInfosJPA extends JpaRepository<TLoggerInfos,Long> {
}
