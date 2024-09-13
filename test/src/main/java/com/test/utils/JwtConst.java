package com.test.utils;

public interface JwtConst {
    //JWT签发者
    String JWT_ID = "098f6bcd4621d373cade4e832627b4f6";
    // 密钥, 经过Base64加密, 可自行替换
    String JWT_SECRECT = "MDk4ZjZiY2Q0NjIxZD";
    // 过期时间，单位毫秒
    int JWT_TTL = 60*60*1000;
}

