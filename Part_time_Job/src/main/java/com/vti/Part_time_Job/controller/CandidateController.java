package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController  {

    @Autowired
    private ICandidateService service ;

    @GetMapping()
    public List<Candidate> findAll() {
        return service.findAll() ;
    }
    @GetMapping("/page/{pageNo}")
    public Page<Candidate> findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam(value = "sortField") String sortField, @RequestParam("sortDir") String sortDirection ) {
        int pageSize = 5 ;
        return service.findPaginated(pageNo,pageSize,sortField,sortDirection) ;
    }
        @GetMapping("/{id}")
    public Candidate findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody Candidate form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Candidate form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
