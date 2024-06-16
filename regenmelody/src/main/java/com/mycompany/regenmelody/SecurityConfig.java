
package com.mycompany.regenmelody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author Erick Montoya
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/", "/home", "/api/login").permitAll()
            .antMatchers("/protected/**").authenticated()
            .antMatchers("/usuarios/register").permitAll() // 
            .and()
        .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/api/login")
            .defaultSuccessUrl("/protected/protected.html", true)
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessUrl("/login.html")
            .permitAll()
            .and()
        .csrf().disable();
}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}