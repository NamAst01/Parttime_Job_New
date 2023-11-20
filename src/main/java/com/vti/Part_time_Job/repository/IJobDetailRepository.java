package com.vti.Part_time_Job.repository;


import com.vti.Part_time_Job.entity.JobDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IJobDetailRepository extends JpaRepository<JobDetail, Integer>, JpaSpecificationExecutor<JobDetail> {
}
