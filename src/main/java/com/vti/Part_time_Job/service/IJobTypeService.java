package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.JobType;

import java.util.List;

public interface IJobTypeService {
    List<JobType> findAll();

    JobType findById(Integer id);

    void create(JobType form);

    void update(JobType form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
