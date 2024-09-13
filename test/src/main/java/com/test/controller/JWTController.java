package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.test.entity.ResultResponse;
import com.test.entity.User;
import com.test.utils.JwtConst;
import com.test.utils.JwtUtil;

import io.jsonwebtoken.Claims;

@Controller
@RequestMapping("/jwt")
public class JWTController {
    @RequestMapping("/login")
    @ResponseBody
    public ResultResponse<String> login(String username, String password) {
        if (username == null || password == null) {
            return new ResultResponse<String>(789, "用户名或密码不正确", null);
        }
        User user = new User(1001, username, password);
        String jwt = JwtUtil.createJWT(JwtConst.JWT_ID, 
JwtUtil.createSubject(user), JwtConst.JWT_TTL);
        System.out.println(jwt);
        return new ResultResponse<>(200, "请求成功！", jwt);
    }
    @RequestMapping("/parseJwt")
    @ResponseBody
    public User parseJwt(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        String token = JSON.parseObject(jwt).getString("token");
        Claims claims = JwtUtil.parseJwt(token);
        String subject = claims.getSubject();
        User user = JSON.parseObject(subject, User.class);
        System.out.println(user);
        return user;
    }
}

