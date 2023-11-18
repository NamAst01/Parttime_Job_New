package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Report;

import java.util.List;

public interface IReportService {
    List<Report> findAll();

    Report findById(Integer id);

    void create(Report form);

    void update(Report form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
