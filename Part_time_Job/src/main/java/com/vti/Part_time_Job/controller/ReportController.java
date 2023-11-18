package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.entity.Report;
import com.vti.Part_time_Job.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController  {

    @Autowired
    private IReportService service ;

    @GetMapping()
    public List<Report> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public Report findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody Report form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Report form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}

