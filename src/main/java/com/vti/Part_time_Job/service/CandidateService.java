package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.repository.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements  ICandidateService {
    @Autowired
    private ICandidateRepository repository ;

    @Override
    public List<Candidate> findAll(){
        return repository.findAll() ;
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

    @Override
    public Page<Candidate> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending() ;
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize , sort);
        return this.repository.findAll(pageable);
    }
}
