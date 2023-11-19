package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import com.vti.Part_time_Job.repository.ICandidateRepository;
import com.vti.Part_time_Job.specification.CandidateSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements  ICandidateService {
    @Autowired
    private ICandidateRepository repository ;

    @Override
    public Page<Candidate> findAll(CandidateFilterForm form, int pageNo, int pageSize, String sortBy, String sortDir){
        Specification<Candidate> spec = CandidateSpecification.buildSpec(form) ;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending() ;
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAll(spec,pageable) ;
    }

    @Override
    public Candidate findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Candidate form) {
        repository.save(form) ;
    }

    @Override
    public void update(Candidate form) {
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
