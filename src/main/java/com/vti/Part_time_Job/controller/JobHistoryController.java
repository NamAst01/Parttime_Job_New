package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.entity.JobHistory;
import com.vti.Part_time_Job.service.IJobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobhistories")
public class JobHistoryController  {

    @Autowired
    private IJobHistoryService service ;

    @GetMapping()
    public List<JobHistory> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public JobHistory findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody JobHistory form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody JobHistory form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
