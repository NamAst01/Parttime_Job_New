package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateCreateForm;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import com.vti.Part_time_Job.form.CandidateUpdateForm;
import com.vti.Part_time_Job.repository.ICandidateRepository;
import com.vti.Part_time_Job.specification.CandidateSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateService implements  ICandidateService {
    @Autowired
    private ICandidateRepository repository ;
    @Autowired
    private ModelMapper mapper ;
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
    @Transactional
    public void create(CandidateCreateForm form) {
        Candidate candidate = mapper.map(form,Candidate.class) ;
        repository.save(candidate) ;
    }

    @Override
    public void update(CandidateUpdateForm form) {
        Candidate candidate = mapper.map(form,Candidate.class) ;
        repository.save(candidate) ;
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
