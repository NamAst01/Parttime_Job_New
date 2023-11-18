package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.entity.JobType;
import com.vti.Part_time_Job.service.IJobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobtypes")
public class JobTypeController  {

    @Autowired
    private IJobTypeService service ;

    @GetMapping()
    public List<JobType> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public JobType findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody JobType form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody JobType form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}

