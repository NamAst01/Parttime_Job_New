package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.FeedBack;
import com.vti.Part_time_Job.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbackss")
public class FeedBackController  {

    @Autowired
    private IFeedBackService service ;

    @GetMapping()
    public List<FeedBack> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public FeedBack findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody FeedBack form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody FeedBack form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}

