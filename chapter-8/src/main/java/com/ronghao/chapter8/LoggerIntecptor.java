package com.ronghao.chapter8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ronghao.chapter8.entity.TLoggerInfos;
import com.ronghao.chapter8.jpa.LoggerInfosJPA;
import com.ronghao.chapter8.utils.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 4:10 PM 3/11/2018
 * ==============================
 **********************************/
public class LoggerIntecptor implements HandlerInterceptor {

    private static final String LOGGER_SEND_TIME = "_send_time";
    private static final String LOGGER_ENTITY = "_logger_entity";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TLoggerInfos logger= new TLoggerInfos();
        String sessionId=request.getRequestedSessionId();
        String url=request.getRequestURI();

        String paramData = JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
        logger.setClientIp(request.getRemoteAddr());
//        logger.setClientIp(LoggerUtils.getClientIp(request));
        logger.setMethod(request.getMethod());
        logger.setType(LoggerUtils.getRequestType(request));
        logger.setParamData(paramData);
        logger.setUri(url);
        logger.setSessionId(sessionId);
        logger.setTime(Timestamp.valueOf(LocalDateTime.now()));
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,logger);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        int status = response.getStatus();
        long currentTime=System.currentTimeMillis();
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        TLoggerInfos loggerInfos = (TLoggerInfos) request.getAttribute(LOGGER_ENTITY);
        loggerInfos.setTimeConsuming(Integer.valueOf((currentTime-time)+""));
        loggerInfos.setReturmTime(currentTime + "");
        loggerInfos.setHttpStatusCode(status + "");
        loggerInfos.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        LoggerInfosJPA loggerDAO=getDAO(LoggerInfosJPA.class,request);
        loggerDAO.save(loggerInfos);
    }


    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getDAO(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
