package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICandidateRepository  extends JpaRepository<Candidate, Integer>, JpaSpecificationExecutor<Candidate> {

}
