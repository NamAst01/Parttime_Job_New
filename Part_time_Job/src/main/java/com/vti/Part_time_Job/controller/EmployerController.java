package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.service.IEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController  {

    @Autowired
    private IEmployerService service ;

    @GetMapping()
    public List<Employer> findAll() {return service.findAll() ;}

    @GetMapping("/{id}")
    public Employer findById(@PathVariable("id") Integer id){return  service.findById(id) ;}

    @PostMapping
    public void create(@RequestBody Employer form) {service.create(form);}


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Employer form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
