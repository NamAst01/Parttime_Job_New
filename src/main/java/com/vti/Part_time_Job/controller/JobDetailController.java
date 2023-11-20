package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.form.JobDetailFilterForm;
import com.vti.Part_time_Job.service.IJobDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobdetails")
public class JobDetailController  {

    @Autowired
    private IJobDetailService service ;

    @GetMapping()
    public Page<JobDetail> findAll(JobDetailFilterForm form,
                                   @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10", required = false)int pageSize,
                                   @RequestParam(name = "sortBy", defaultValue = "id", required = false)String sortBy,
                                   @RequestParam(name = "sortDir", defaultValue = "asc", required = false)String sortDir) {

        return service.findAll( form, pageNo, pageSize, sortBy, sortDir) ;
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
