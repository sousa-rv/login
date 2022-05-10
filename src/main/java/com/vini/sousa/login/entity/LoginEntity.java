package com.vini.sousa.login.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("login_entity")
public class LoginEntity {

    private String username;

    private String password;

    private String function;

    private String age;

    private String nationality;

    private String temporaryToken;
}
