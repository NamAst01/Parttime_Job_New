package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateCreateForm;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import com.vti.Part_time_Job.form.CandidateUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICandidateService {
    Page<Candidate> findAll(CandidateFilterForm form, int pageNo, int pageSize, String sortBy, String sortDir);

    Candidate findById(Integer id);

    void create(CandidateCreateForm form);

    void update(CandidateUpdateForm form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);

}
