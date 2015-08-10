package com.heroclone.internal.springsample.api.service.impl;

import org.springframework.stereotype.Service;

import com.heroclone.internal.springsample.api.domain.NDUSPerson;
import com.heroclone.internal.springsample.api.service.NDUSPersonService;

@Service
public class NDUSPersonServiceActiveDirectory implements NDUSPersonService {
    
    @Override
    public NDUSPerson fetchByEmpl(long id) {
        
        return null;
    }   
}