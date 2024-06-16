package com.mycompany.regenmelody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.HttpStatus;


/**
 *
 * @author Erick Montoya
 */

/*@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    
    @Autowired
    private UserDetailsService userDetailsService;
     
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    
   @PostMapping("/register")
public ResponseEntity<String> registerUser(@RequestBody User user) {
    String contraseña = user.getContraseña();
    if (contraseña == null || contraseña.isEmpty()) {
        return ResponseEntity.status(400).body("Password cannot be null or empty");
    }
    
    Optional<User> userOpt = userRepository.findByNombreUsuario(user.getNombreUsuario());
    if (userOpt.isPresent()) {
        return ResponseEntity.status(400).body("Username already exists");
    }
    
    String encryptedPassword = customUserDetailsService.encryptPassword(contraseña);
    user.setContraseña(encryptedPassword);
    userRepository.save(user);
    return ResponseEntity.ok("Registration successful");

}

@PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody User user, HttpServletResponse response, HttpSession session) throws IOException {
        logger.info("Intento de login con usuario: {}", user.getNombreUsuario());
        Optional<User> userOpt = userRepository.findByNombreUsuario(user.getNombreUsuario());
        
        boolean isAuthenticated = customUserDetailsService.authenticate(user.getNombreUsuario(), user.getContraseña());
        
        if (isAuthenticated) {
            User foundUser = userOpt.get();
            
            logger.info("Usuario encontrado: {}", foundUser.getNombreUsuario());

            // Cargar los detalles del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(foundUser.getNombreUsuario());

            // Establecer el contexto de seguridad
            UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userDetails, foundUser.getContraseña(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);

            response.sendRedirect("/protected/protected.html");
        } else {
            logger.error("Usuario o contraseña incorrectos para usuario: {}", user.getNombreUsuario());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
    }

}*/
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String contraseña = user.getContraseña();
        if (contraseña == null || contraseña.isEmpty()) {
            return ResponseEntity.status(400).body("Password cannot be null or empty");
        }

        Optional<User> userOpt = userRepository.findByNombreUsuario(user.getNombreUsuario());
        if (userOpt.isPresent()) {
            return ResponseEntity.status(400).body("Username already exists");
        }

        String encryptedPassword = customUserDetailsService.encryptPassword(contraseña);
        user.setContraseña(encryptedPassword);
        userRepository.save(user);
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestBody User user, HttpServletResponse response, HttpSession session) throws IOException {
        logger.info("Intento de login con usuario: {}", user.getNombreUsuario());
        Optional<User> userOpt = userRepository.findByNombreUsuario(user.getNombreUsuario());
        
        boolean isAuthenticated = customUserDetailsService.authenticate(user.getNombreUsuario(), user.getContraseña());
        
        if (isAuthenticated) {
            if (userOpt.isPresent()) {
                User foundUser = userOpt.get();
                logger.info("Usuario encontrado: {}", foundUser.getNombreUsuario());

                // Cargar los detalles del usuario
                UserDetails userDetails = userDetailsService.loadUserByUsername(foundUser.getNombreUsuario());

                // Establecer el contexto de seguridad
                UsernamePasswordAuthenticationToken authToken = 
                        new UsernamePasswordAuthenticationToken(userDetails, foundUser.getContraseña(), userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);

                // Guardar el contexto de seguridad en la sesión
                // session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

                response.sendRedirect("/protected/protected.html");
            } else {
                logger.error("Usuario no encontrado: {}", user.getNombreUsuario());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
            }
        } else {
            logger.error("Usuario o contraseña incorrectos para usuario: {}", user.getNombreUsuario());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario o contraseña incorrectos");
        }
    }
}