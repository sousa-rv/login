package com.vini.sousa.login;

import com.vini.sousa.login.entity.LoginEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class TokenFactory {

    private final String SERVER_URL = "localhost:8080";

    private final SecretKey KEY = Keys.hmacShaKeyFor(
            "7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
                    .getBytes(StandardCharsets.UTF_8));

    public String generate(LoginEntity loginEntity) {
        String jwtToken = Jwts.builder()
                .setSubject(loginEntity.getUsername())
                .setSubject(loginEntity.getAge())
                .setSubject(loginEntity.getFunction())
                .setSubject(loginEntity.getNationality())
                .setIssuer(SERVER_URL)
                .setIssuedAt(new Date())
                .setExpiration(
                        Date.from(
                                LocalDateTime.now().plusMinutes(15L)
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant()))
                .signWith(KEY, SignatureAlgorithm.RS512)
                .compact();

        return jwtToken;
    }
}
