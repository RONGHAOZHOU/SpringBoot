package com.ronghao.chapter7.enums;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 2:35 PM 3/10/2018
 * ==============================
 **********************************/
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;

    MailContentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
