package com.nuaa.back_ma.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: raintor
 * @Date: 2019/5/30 16:34
 * @Description:
 */
public class PassWordEncoding {

    public static String encoding(String password){
        BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(password);
        return encode;
    }

    public static void main(String[] args) {
        System.out.println(encoding("fox"));
    }
}

