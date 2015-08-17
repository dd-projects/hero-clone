package com.heroclone.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroclone.api.entity.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}