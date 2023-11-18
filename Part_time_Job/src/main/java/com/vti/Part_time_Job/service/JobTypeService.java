package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.JobType;
import com.vti.Part_time_Job.repository.IJobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeService implements IJobTypeService {
    @Autowired
    private IJobTypeRepository repository ;

    @Override
    public List<JobType> findAll(){
        return repository.findAll() ;
    }

    @Override
    public JobType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(JobType form) {
        repository.save(form) ;
    }

    @Override
    public void update(JobType form) {
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
