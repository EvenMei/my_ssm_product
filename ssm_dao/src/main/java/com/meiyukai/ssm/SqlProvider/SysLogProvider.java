package com.meiyukai.ssm.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SysLogProvider {
    //sysLog 的provider
    //StringBuffer 的拼接方式实现
   /* public String insertProvider(Map<String , Object> map){
        String username  = (String) map.get("username");
        String url  = (String) map.get("url");
        StringBuffer sb = new StringBuffer();
        sb.append("select * from sysLog where 1=1 ");
        if(username!=null){
            sb.append("  and username like '%"+username+"%'");
        }
        if(url !=null){
            sb.append(" and url =  '"+url+"'");
        }
        return sb.toString();
    }*/


    public String insertProvider(Map<String , Object> map){
        String username = (String) map.get("username");

      return new SQL(){
          {
              SELECT(" * from sysLog");
              if(username != null && username !=""){

                  WHERE("username like '%"+username+"%'");
              }
          }
      }.toString();
    }





}
