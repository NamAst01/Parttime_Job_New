package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Comment;
import com.vti.Part_time_Job.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController  {

    @Autowired
    private ICommentService service ;

    @GetMapping()
    public List<Comment> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody Comment form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Comment form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);
    }
}
