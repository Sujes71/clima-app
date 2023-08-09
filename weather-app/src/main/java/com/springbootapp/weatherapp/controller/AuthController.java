package com.springbootapp.weatherapp.controller;

import com.springbootapp.weatherapp.service.component.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController{

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @GetMapping("/token/{code}")
    public ResponseEntity<String> getToken(@PathVariable String code) {
        String token = this.jwtTokenUtil.generateToken(code);

        if (code != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/code/random")
    public ResponseEntity<String> getRandomCode() {
        String code = this.jwtTokenUtil.generateRandomCode();

        if (code != null) {
            return ResponseEntity.ok(code);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
