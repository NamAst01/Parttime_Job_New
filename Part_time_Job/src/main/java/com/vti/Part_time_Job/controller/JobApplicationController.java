package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.JobApplication;
import com.vti.Part_time_Job.service.IJobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobapplications")
public class JobApplicationController  {

    @Autowired
    private IJobApplicationService service ;

    @GetMapping()
    public List<JobApplication> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public JobApplication findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody JobApplication form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody JobApplication form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
