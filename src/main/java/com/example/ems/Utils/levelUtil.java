package com.example.ems.Utils;

import org.apache.commons.lang3.StringUtils;

public class levelUtil {
    private final static String SEPARATOR =".";
    public final static String ROOT="";
    public static String calculatelevel(String parentLevel,int Id){
        if (StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else{
            System.out.println(StringUtils.join(parentLevel,SEPARATOR,Id));
            return StringUtils.join(parentLevel,SEPARATOR,Id);
            //0
            //0.1
            //0.0.1
        }
    }
}
