package com.vini.sousa.login.controller;

import com.vini.sousa.login.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> login(LoginDTO loginDTO) {
        
    }
}
