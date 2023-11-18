package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.JobApplication;

import java.util.List;

public interface IJobApplicationService {
    List<JobApplication> findAll();

    JobApplication findById(Integer id);

    void create(JobApplication form);

    void update(JobApplication form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
