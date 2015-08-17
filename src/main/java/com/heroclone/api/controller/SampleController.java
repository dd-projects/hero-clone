package com.heroclone.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heroclone.api.entity.Sample;
import com.heroclone.api.repository.SampleRepository;
import com.heroclone.api.service.SampleService;

@RestController
@RequestMapping("api")
public class SampleController {
    @Autowired private SampleRepository sampleRepository;
    @Autowired private SampleService sampleService;
    
    @RequestMapping(value="getSamples", method=RequestMethod.GET)
    public List<Sample> getSamples() {
        return this.sampleRepository.findAll();
    }
    
    @RequestMapping(value="getSample", method=RequestMethod.GET)
    public Sample getSample(@RequestParam Long id) {
        return this.sampleRepository.findOne(id);
    }
    
    @RequestMapping(value="populateRandomSamples", method=RequestMethod.POST)
    public void populateRandomSamples(@RequestParam int count) {
        this.sampleService.populateRandom(count);
    }
}