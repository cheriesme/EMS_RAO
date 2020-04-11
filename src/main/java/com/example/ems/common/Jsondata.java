package com.example.ems.common;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Jsondata {
   private boolean ret;
   private String msg;
   private Object data;
   public Jsondata(boolean ret){
           this.ret = ret;
   }
   public static Jsondata success(Object object,String msg){
           Jsondata jsondata = new Jsondata(true);
           jsondata.data = object;
           jsondata.msg = msg;
           return jsondata;
   }
    public static Jsondata success(Object object){
            Jsondata jsondata = new Jsondata(true);
            jsondata.data = object;
            return jsondata;
    }
    public static Jsondata success(){
            Jsondata jsondata = new Jsondata(true);
           return jsondata;
    }
    public static Jsondata fail(String msg){
       Jsondata jsondata = new Jsondata(true);
       jsondata.msg = msg;
       return jsondata;
    }
    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("set",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }
    }
