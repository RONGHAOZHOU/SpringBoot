package com.ronghao.chapter7;

import com.ronghao.chapter7.core.MailSender;
import com.ronghao.chapter7.enums.MailContentTypeEnum;

import java.util.ArrayList;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 5:51 PM 3/10/2018
 * ==============================
 **********************************/
public class TestMail {
    public static void main(String[] args) throws Exception{
        new MailSender()
                .title("Test for send Email")
                .content("Simple email message")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("505360893@qq.com");
                }})
                .send();

    }
}
