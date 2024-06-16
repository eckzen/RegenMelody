/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.regenmelody;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Erick Montoya
 */
public interface MixRepository extends JpaRepository<Mix, Long> {
    List<Mix> findByUserId(Long userId);
}

/* Código anterior
public interface MixRepository extends JpaRepository<Mix, Long> {
    List<Mix> findByUser(User user);
}
*/