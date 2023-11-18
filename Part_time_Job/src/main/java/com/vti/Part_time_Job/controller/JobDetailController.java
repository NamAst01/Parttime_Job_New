package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.service.IJobDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobdetails")
public class JobDetailController  {

    @Autowired
    private IJobDetailService service ;

    @GetMapping()
    public List<JobDetail> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public JobDetail findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody JobDetail form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody JobDetail form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
