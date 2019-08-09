package com.brageast.blog.util;

import com.brageast.blog.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {
    public static final long EXPIRATIONTIME = 86_400_000;   // 过期时间 默认一天
    public static final String SECRET = "X2@0ZhlHeng";  // 密码
    public static final String TOKEN_PREFIX = "Bearer"; // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key



    /**
     * @param user
     * @return String
     * @describe 生成一个简单的token
     */
    public static String builder(User user) {
        if (user == null) return null;
        return Jwts.builder()
                    .setId(String.valueOf(user.getId())) // 设置ID
                    .setSubject(user.getName()) // 设置名字
                    .setIssuedAt(new Date()) //设置创建时间
                    .signWith(SignatureAlgorithm.HS512, SECRET) // 签名and算法
                    .claim("group", user.getGroups()) // 设置group组
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)) // 设置有效时间
                    .compact();

    }

    /**
     * @param token
     * @return Claims
     * @describe 验证并解码一个token
     */
    public static Claims getClaims(String token){
        Claims body = null;
        try {
            body = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token).getBody();

        } catch(JwtException e) {
//            log.error(e.getMessage());
            return null;
        }

        return body;
    }

    public static String getTokeSubject(String token) {
        return getClaims(token).getSubject();
    }

    public static Date getTokeExpiration(String token) {
        return getClaims(token).getExpiration();
    }
    //检查是否过期
    public static Boolean isTokenExpired(String token) {
        final Date expiration = getTokeExpiration(token);
        return expiration.before(new Date());
    }

}
