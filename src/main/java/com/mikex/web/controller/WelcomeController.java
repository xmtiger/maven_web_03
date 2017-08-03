package com.mikex.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public class WelcomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "welcome";
	}
        
        //if index.html exists under folder webapp, the following handler method is required. 
        //Otherwise the following method is not required.
        /*@RequestMapping(value="/index.html")
        public String indexPage(){
            return "/welcome";
        }*/

}
