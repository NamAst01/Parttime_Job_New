package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Employer;

import java.util.List;


public interface IEmployerService {
     List<Employer> findAll();

     Employer findById(Integer id);

     void create(Employer form);

     void update(Employer form);

     void deleteById(Integer id);

     void deleteAllById(List<Integer> ids);
}