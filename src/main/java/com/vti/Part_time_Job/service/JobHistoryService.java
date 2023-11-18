package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.JobHistory;
import com.vti.Part_time_Job.repository.IJobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryService implements IJobHistoryService {
    @Autowired
    private IJobHistoryRepository repository ;

    @Override
    public List<JobHistory> findAll(){
        return repository.findAll() ;
    }

    @Override
    public JobHistory findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(JobHistory form) {
        repository.save(form) ;
    }

    @Override
    public void update(JobHistory form) {
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
