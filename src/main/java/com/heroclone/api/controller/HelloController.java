package com.heroclone.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.heroclone.api.dao.SampleDAO;
import com.heroclone.api.model.Sample;

@Controller
@RequestMapping("api")
public class HelloController {

    @Autowired
    SampleDAO sampleDAO;

    @Value("${app.name}")
    private String appname;

    @ResponseBody
    @RequestMapping(value = "getobj", method = RequestMethod.POST)
    public Object getObj() {
        String x = "YO!";
        return x;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView hello() {
        Sample s = new Sample();
        s.setName("OBJECT_TABLE_33X22");
        s.setIcon("http://www.google.com");
        s.setWalkable(false);

        List<Sample> list = sampleDAO.list();

        ModelAndView model = new ModelAndView("hello");
        model.addObject("msg", list);
        return model;
    }
}