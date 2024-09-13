package com.test.utils;


import com.alibaba.fastjson.JSON;
import com.test.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Calendar;

public class JwtUtil {
	   private static Key key =  Keys.secretKeyFor(SignatureAlgorithm.HS256);
	    public static String createJWT(String id, String subject, int ttl) {
	        Calendar calendar = Calendar.getInstance();
	        JwtBuilder builder = Jwts.builder()
	                .setId(id)  //JWT唯一标识
	                .setIssuedAt(calendar.getTime()) //签发时间
	                .setSubject(subject) //JWT的主题，比如JSON类型的User对象
	                .signWith(key);
	        calendar.add(Calendar.MINUTE, ttl); // ttl过期时间，单位分钟
	        builder.setExpiration(calendar.getTime()); //过期时间
	        return builder.compact();
	    }
	    public static Claims parseJwt(String jwt){
	        Claims claims = Jwts.parserBuilder().setSigningKey(key)
	.build().parseClaimsJws(jwt).getBody();
	        return claims;
	    }
	    public static String createSubject(User user){
	        return JSON.toJSONString(user);
	    }
	}

