package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.EmployerCreateFrom;
import com.vti.Part_time_Job.form.EmployerFilterForm;
import com.vti.Part_time_Job.form.EmployerUpdateForm;
import com.vti.Part_time_Job.repository.IEmployerRepository;
import com.vti.Part_time_Job.specification.CandidateSpecification;
import com.vti.Part_time_Job.specification.EmployerSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService implements  IEmployerService {
    @Autowired
    private IEmployerRepository repository ;
    @Autowired
    ModelMapper mapper ;

    @Override
    public Page<Employer> findAll(EmployerFilterForm form , int pageSize , int pageNo ,String sortBy, String sortDir ){
        Specification<Employer> spec = EmployerSpecification.buildSpec(form) ;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending() ;
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAll(spec, pageable) ;
    }

    @Override
    public Employer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(EmployerCreateFrom form) {
        Employer employer = mapper.map(form,Employer.class) ;
        repository.save(employer) ;
    }

    @Override
    public void update(EmployerUpdateForm form) {
        Employer employer = mapper.map(form,Employer.class) ;
        repository.save(employer) ;
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
