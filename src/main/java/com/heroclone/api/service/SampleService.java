package com.heroclone.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heroclone.api.helper.RandomHelper;
import com.heroclone.api.repository.SampleRepository;
import com.heroclone.api.entity.Sample;

@Service
public class SampleService {
    @Autowired SampleRepository sampleRepository;
    
    @Transactional
    public void populateRandom(int count) {
        this.sampleRepository.deleteAllInBatch();
        
        for (; count > 0; count--) {
            Sample sample = new Sample();
            
            int rand1 = RandomHelper.randInt(0, 5*count);
            int rand2 = RandomHelper.randInt(1, 3);
            int rand3 = RandomHelper.randInt(0, 1);
            
            String icon = String.format("http://robohash.org/%d?set=set%d", rand1, rand2);
            
            String name = Integer.toString(rand1*rand2);
            
            sample.setIcon(icon);
            sample.setWalkable(rand3 == 0);
            sample.setName(name);
            this.sampleRepository.save(sample);
        }
    }
}
