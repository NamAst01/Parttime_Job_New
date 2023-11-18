package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.JobApplication;
import com.vti.Part_time_Job.repository.IJobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService implements IJobApplicationService {

    @Autowired
     private IJobApplicationRepository repository ;
    @Override
    public List<JobApplication> findAll(){
        return repository.findAll() ;
    }

    @Override
    public JobApplication findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(JobApplication form) {
        repository.save(form) ;
    }

    @Override
    public void update(JobApplication form) {
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
