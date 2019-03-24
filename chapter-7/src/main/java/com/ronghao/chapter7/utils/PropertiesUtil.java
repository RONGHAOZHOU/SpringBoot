package com.ronghao.chapter7.utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 2:55 PM 3/10/2018
 * ==============================
 **********************************/
public class PropertiesUtil {
    private final ResourceBundle resource;
    private final String fileName;

    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale=new Locale("zh");
        this.resource = ResourceBundle.getBundle(this.fileName,locale);
    }

    public String getValue(String key) {
        String message = this.resource.getString(key);
        return message;
    }
    
    public Enumeration<String> getkeys(){
        return resource.getKeys();
    }


}
