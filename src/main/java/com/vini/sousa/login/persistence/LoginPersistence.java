package com.vini.sousa.login.persistence;

import com.vini.sousa.login.dto.LoginDTO;
import com.vini.sousa.login.entity.LoginEntity;
import com.vini.sousa.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginPersistence {

    @Autowired
    private LoginRepository loginRepository;

    public LoginEntity findByLogin(String username) {

        try {
            return loginRepository.findByUsername(username).get();
        } catch(NoSuchElementException e) {
            return null;
        }
    }

    public LoginEntity updateLoginToken(String username, String token) {
        LoginEntity loginEntity = findByLogin(username);

        loginRepository.delete(loginEntity);

        loginEntity.setTemporaryToken("");

        return loginRepository.save(loginEntity);
    }
}
