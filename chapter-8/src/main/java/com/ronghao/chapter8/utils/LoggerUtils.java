package com.ronghao.chapter8.utils;

import javax.servlet.http.HttpServletRequest;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 4:25 PM 3/11/2018
 * ==============================
 **********************************/
public final class LoggerUtils {
    public static final String LOGGER_RETURN = "_logger_return";

    public LoggerUtils() {}

    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        final String[] arr=ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip=str;
                break;
            }
        }
        return ip;
    }

    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }

}

