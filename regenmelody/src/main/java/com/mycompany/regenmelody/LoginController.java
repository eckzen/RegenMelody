/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.regenmelody;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick Montoya
 */

@RestController
@RequestMapping("/api")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> credentials, HttpServletResponse response) throws IOException {
        String username = credentials.get("username");
        String password = credentials.get("password");

        logger.info("Login attempt for user: {}", username);

        boolean isAuthenticated = customUserDetailsService.authenticate(username, password);

        if (isAuthenticated) {
            logger.info("Login successful for user: {}", username);
            response.sendRedirect("/protected/protected.html");
        } else {
            logger.warn("Login failed for user: {}", username);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password");
        }
    }
}
 /*@GetMapping("/login") 
    public String getLogin() {
        
        return "login"; 
    }*/