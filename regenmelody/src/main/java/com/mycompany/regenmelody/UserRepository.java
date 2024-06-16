/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.regenmelody;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 *
 * @author Erick Montoya
 */

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNombreUsuario(String nombreUsuario);
}

