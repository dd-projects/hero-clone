package com.heroclone.api.dao;

import java.util.List;

import com.heroclone.api.model.Sample;

public interface SampleDAO {

    public void save(Sample s);

    public List<Sample> list();
}
