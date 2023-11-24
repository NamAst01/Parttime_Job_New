package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.EmployerFilterForm;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IEmployerService {
     Page<Employer> findAll(EmployerFilterForm form , int pageSize , int pageNo , String sortBy, String sortDir );

     Employer findById(Integer id);

     void create(Employer form);

     void update(Employer form);

     void deleteById(Integer id);

     void deleteAllById(List<Integer> ids);
}