package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.repository.IJobDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDetailService implements IJobDetailService {
    @Autowired
    private IJobDetailRepository repository ;

    @Override
    public List<JobDetail> findAll(){
        return repository.findAll() ;
    }

    @Override
    public JobDetail findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(JobDetail form) {
        repository.save(form) ;
    }

    @Override
    public void update(JobDetail form) {
        repository.save(form) ;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
