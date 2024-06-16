
package com.mycompany.regenmelody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Erick Montoya
 */

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
