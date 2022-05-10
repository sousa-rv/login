package com.vini.sousa.login.domain;

import com.vini.sousa.login.TokenFactory;
import com.vini.sousa.login.dto.LoginDTO;
import com.vini.sousa.login.entity.LoginEntity;
import com.vini.sousa.login.exception.LoginAuthenticationException;
import com.vini.sousa.login.persistence.LoginPersistence;
import io.jsonwebtoken.Jwts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class LoginService {

    private final String PASSWORDS_DO_NOT_MATCH = "The password typed does not the match the password in the database.";

    private static final int EXPIRY_DAYS = 90;

    @Autowired
    LoginPersistence loginPersistence;

    @Autowired
    TokenFactory tokenFactory;

    public void check(LoginDTO loginDTO) {
        LoginEntity loginEntity = loginPersistence.findByLogin(loginDTO.getUsername());

        if (loginEntity.getPassword() != loginDTO.getPassword()) {
            throw new LoginAuthenticationException(PASSWORDS_DO_NOT_MATCH);
        }

        String generatedToken = tokenFactory.generate(loginEntity);

        loginPersistence.updateLoginToken(loginDTO.getUsername(), generatedToken);
    }
}
