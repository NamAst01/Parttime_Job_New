package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.JobDetail;

import java.util.List;

public interface IJobDetailService {
    List<JobDetail> findAll();

    JobDetail findById(Integer id);

    void create(JobDetail form);

    void update(JobDetail form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
