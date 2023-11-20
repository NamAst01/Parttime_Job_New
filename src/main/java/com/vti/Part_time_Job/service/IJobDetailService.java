package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.form.JobDetailFilterForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IJobDetailService {
    Page<JobDetail> findAll(JobDetailFilterForm form , int pageNo, int pageSize, String sortBy, String sortDir);

    JobDetail findById(Integer id);

    void create(JobDetail form);

    void update(JobDetail form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
