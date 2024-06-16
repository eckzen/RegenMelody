
package com.mycompany.regenmelody;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author Erick Montoya
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByNombreUsuario(username);
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOpt.get();
        return org.springframework.security.core.userdetails.User.withUsername(user.getNombreUsuario()) 
                .password(user.getContraseña()) 
                .roles("USER").build();
    }

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByNombreUsuario(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return bCryptPasswordEncoder.matches(password, user.getContraseña()); 
        }
        return false;
    }

    public String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
