/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MikeX
 */
@Controller
@RequestMapping("helloPage")
public class HelloController {
    
    @RequestMapping("")
    public String helloPage(){
        return "helloPage";
    }
}
