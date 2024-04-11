package com.sandbox.jwt.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

@Service
@Slf4j
public class TestJwtService {

//    @Value("${secret-key}")
//    private String secretKey;
    @Value("${token-secret-key}")
    private String secretKey2;

    public String getToken() {
        log.info(secretKey2);
        return Jwts
                .builder()
                .setClaims(Collections.singletonMap("testSingletonClaimsKey", "testSingletonClaimsValue"))
                .setSubject("testSubject")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 300))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey2);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
