package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.repository.IEmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService implements  IEmployerService {
    @Autowired
    private IEmployerRepository repository ;

    @Override
    public List<Employer> findAll(){
        return repository.findAll() ;
    }

    @Override
    public Employer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Employer form) {
        repository.save(form) ;
    }

    @Override
    public void update(Employer form) {
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
