package com.heroclone.internal.springsample.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("api")
public class HelloController {

    //@Autowired
    //NDUSActiveDirectoryLdapAuthenticationProvider adAuthenticationProvider;
    
    @Value("${app.name}")
    private String appname;
    
    @ResponseBody
    @RequestMapping(value="getobj", method = RequestMethod.POST)
    public Object getObj() {
    	String x = "YO!";
    	return x;
    }
    
    @RequestMapping(value="hello", method=RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView model = new ModelAndView("hello");
		model.addObject("msg", "hello world");
		return model;
    }
}