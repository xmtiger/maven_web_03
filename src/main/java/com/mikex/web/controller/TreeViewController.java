/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author MikeX
 */
@Controller
@RequestMapping(value = "treeView")
public class TreeViewController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
	public String testView() {
		return "treeView";
	}
}
