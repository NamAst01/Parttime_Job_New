package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployerRepository extends JpaRepository<Employer, Integer> {
}
