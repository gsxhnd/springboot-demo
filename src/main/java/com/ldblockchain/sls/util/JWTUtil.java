package com.ldblockchain.sls.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil{
    private static final String CLAIM_KEY_CREATED = "created";

    // 加密密钥
    private static final String SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";

    // 过期时间
    private static final Long EXPIRATION = 7200L;

    /**
     * 生成jwt token
     * @param key 加密的内容
     * @param expiration 过期时间
     * @return jwt
     */
    public static String generateToken(String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    private static String generateToken(Map<String, Object> claims) {
        System.out.println(EXPIRATION);
        System.out.println(SECRET);
        return Jwts.builder()
                .setClaims(claims)                                                                        // 自定义属性
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION * 1000))                // 过期时间
                .signWith(SignatureAlgorithm.HS512, SECRET)                                           // 签名算法以及密匙
                .compact();
    }

    /**
     * 刷新jwt
     * @param claims claims
     * @param singingKey 密钥
     * @param expiration 过期时间
     * @return 刷新后的jwt
     */
//    static String refreshToken(Claims claims, String singingKey, Long expiration) {
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims, singingKey, expiration);
//    }


    /**
     * @func 检查token, 只要不正确就会抛出异常
     * @author jimo
     * @date 17-12-12 下午6:21
     */
    public static void checkToken(String token) throws ServletException {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e1) {
            throw new ServletException("token expired");
        } catch (Exception e) {
            throw new ServletException("other token exception");
        }
    }

    /**
     * @func token ok返回true
     * @author wangpeng
     * @date 2018/8/27 16:59
     */
    public static boolean isTokenOk(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
