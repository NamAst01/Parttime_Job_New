package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Integer> {
}
