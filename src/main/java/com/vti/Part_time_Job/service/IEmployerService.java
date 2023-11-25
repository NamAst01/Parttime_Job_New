package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.dto.EmployerDto;
import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.EmployerCreateFrom;
import com.vti.Part_time_Job.form.EmployerFilterForm;
import com.vti.Part_time_Job.form.EmployerUpdateForm;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IEmployerService {
     Page<Employer> findAll(EmployerFilterForm form , int pageSize , int pageNo , String sortBy, String sortDir );

     Employer findById(Integer id);

     void create(EmployerCreateFrom form);

     void update(EmployerUpdateForm form);

     void deleteById(Integer id);

     void deleteAllById(List<Integer> ids);
}