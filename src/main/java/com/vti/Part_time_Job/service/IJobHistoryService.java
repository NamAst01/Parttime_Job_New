package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.JobHistory;

import java.util.List;

public interface IJobHistoryService {
    List<JobHistory> findAll();

    JobHistory findById(Integer id);

    void create(JobHistory form);

    void update(JobHistory form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
