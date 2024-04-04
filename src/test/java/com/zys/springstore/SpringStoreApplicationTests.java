package com.zys.springstore;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class SpringStoreApplicationTests {
    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }

    }

    //生成jwt
    @Test
    public void testGenJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "zys11130036")//签名算法
                .setClaims(claims)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期1h
                .compact();

        System.out.println(jwt);
    }

    //解析jwt
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("zys11130036")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxMTYxODE5Mn0.BZUFeLc38hGEeMPIn00L5tZjerLzTBbBiUtqMI9f4-A")
                .getBody();

        System.out.println(claims);
    }

}
