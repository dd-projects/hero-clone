package com.heroclone.impl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
    @Value("${app.apiBaseUrl}")
    private String apiLocation;
    
    @Value("${app.baseUrl}")
    private String appLocation;
    
    @ModelAttribute("apiLocation")
    public String getApiLocation() {
        return this.apiLocation;
    };
    
    @ModelAttribute("appLocation")
    public String getAppLocation() {
        return this.appLocation;
    }
    
    @RequestMapping(value = "", method=RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }
}
