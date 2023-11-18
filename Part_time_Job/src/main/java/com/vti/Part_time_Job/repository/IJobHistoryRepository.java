package com.vti.Part_time_Job.repository;


import com.vti.Part_time_Job.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobHistoryRepository extends JpaRepository<JobHistory, Integer> {
}
