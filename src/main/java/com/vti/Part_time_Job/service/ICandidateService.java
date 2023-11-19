package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICandidateService {
    Page<Candidate> findAll(CandidateFilterForm form, Pageable pageable);

    Candidate findById(Integer id);

    void create(Candidate form);

    void update(Candidate form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
    Page< Candidate > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
