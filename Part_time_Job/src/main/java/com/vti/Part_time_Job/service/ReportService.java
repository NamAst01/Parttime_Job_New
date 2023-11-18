package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Report;
import com.vti.Part_time_Job.repository.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IReportRepository repository ;

    @Override
    public List<Report> findAll(){
        return repository.findAll() ;
    }

    @Override
    public  Report findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Report form) {
        repository.save(form) ;
    }

    @Override
    public void update(Report form) {
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
