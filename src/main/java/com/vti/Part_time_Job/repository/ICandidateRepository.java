package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository  extends JpaRepository<Candidate, Integer> {

}
