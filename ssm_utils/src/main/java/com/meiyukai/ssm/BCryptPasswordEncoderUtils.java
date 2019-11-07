package com.meiyukai.ssm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public static String encode(String password){

        return passwordEncoder.encode(password );
    }



    //测试加密的效果
    public static void main(String[] args) {
        String password =  "hello";
        System.out.println("after passwordEncoder  :   " + BCryptPasswordEncoderUtils.encode(password));
        //两次加密结果不一样
        //$2a$10$fhUeG2wqrX3l7mmy5OY8ReqwF5ny9cvhic2rtjRAFDCjFpFT
        // $2a$10$qiE3IPQLXizjuZ7t2Uzj4.lUdvJBpVNEXi/XrUYUU6fpYgLofnpVS
    }
}
