package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import com.vti.Part_time_Job.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController  {

    @Autowired
    private ICandidateService service ;

    @GetMapping()
    public Page<Candidate> findAll(CandidateFilterForm form,
                                   @RequestParam(value = "pageNo" ,defaultValue = "0", required = false) int pageNo,
                                   @RequestParam(value = "pageSize" ,defaultValue = "10", required = false)int pageSize,
                                   @RequestParam(value = "sortBy" ,defaultValue = "id", required = false)String sortBy,
                                   @RequestParam(value = "sortDir" ,defaultValue = "asc", required = false)String sortDir) {
        return service.findAll(form,  pageNo,  pageSize,  sortBy,  sortDir) ;
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
