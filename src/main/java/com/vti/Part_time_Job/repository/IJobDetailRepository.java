package com.vti.Part_time_Job.repository;


import com.vti.Part_time_Job.entity.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobDetailRepository extends JpaRepository<JobDetail, Integer> {
}
