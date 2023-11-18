package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobApplicationRepository extends JpaRepository<JobApplication, Integer> {
}
