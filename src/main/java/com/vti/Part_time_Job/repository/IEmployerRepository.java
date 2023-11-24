package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEmployerRepository extends JpaRepository<Employer, Integer> , JpaSpecificationExecutor<Employer> {
}
