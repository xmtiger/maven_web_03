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
 * @author xmtig
 */
@Controller
@RequestMapping("helloSpring")
public class HelloSpringController {
    
    @RequestMapping("/id=1")
    public String helloSpringPage(){
        return "helloSpring";
    }
}
