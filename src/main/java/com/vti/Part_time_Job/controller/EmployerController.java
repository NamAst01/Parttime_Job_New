package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.dto.EmployerDto;
import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.EmployerCreateFrom;
import com.vti.Part_time_Job.form.EmployerFilterForm;
import com.vti.Part_time_Job.form.EmployerUpdateForm;
import com.vti.Part_time_Job.service.IEmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController  {

    @Autowired
    private IEmployerService service ;
    @Autowired
    private ModelMapper mapper ;

    @GetMapping()
    public Page<EmployerDto> findAll(EmployerFilterForm form ,
                                     @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo ,
                                     @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                     @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy ,
                                     @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        Page<Employer> emplyers =  service.findAll( form , pageSize,  pageNo ,  sortBy, sortDir) ;
        return  emplyers.map(employer -> mapper.map(employer,EmployerDto.class).withSelfRel()) ;
    }

    @GetMapping("/{id}")
    public EmployerDto findById(@PathVariable("id") Integer id){
        return mapper.map( service.findById(id), EmployerDto.class)  ;
    }

    @PostMapping
    public void create(@RequestBody EmployerCreateFrom form) {service.create(form);}


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody EmployerUpdateForm form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
