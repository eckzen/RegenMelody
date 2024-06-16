/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.regenmelody;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erick Montoya
 */

@RestController
@RequestMapping("/api/mixes")
public class MixController {

    @Autowired
    private MixRepository mixRepository;

    @GetMapping("/user/{userId}")
    public List<Mix> getMixesByUser(@PathVariable Long userId) {
        return mixRepository.findByUserId(userId);
    }

    @PostMapping
    public Mix createMix(@RequestBody Mix mix) {
        return mixRepository.save(mix);
    }
}