package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.form.JobDetailFilterForm;
import com.vti.Part_time_Job.repository.IJobDetailRepository;
import com.vti.Part_time_Job.specification.JobDetailSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDetailService implements IJobDetailService {
    @Autowired
    private IJobDetailRepository repository ;

    @Override
    public Page<JobDetail> findAll(JobDetailFilterForm form , int pageNo, int pageSize, String sortBy, String sortDir){
        Specification<JobDetail> spec = JobDetailSpecification.buildSpec(form) ;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending() ;
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort) ;
        return repository.findAll(spec, pageable) ;
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
