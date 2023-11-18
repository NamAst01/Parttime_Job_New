package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController  {

    @Autowired
    private IAccountService service ;

    @GetMapping()
    public List<Account> findAll() {
        return service.findAll() ;
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Integer id){
        return  service.findById(id) ;
    }

    @PostMapping
    public void create(@RequestBody Account form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Account form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id){
          service.deleteById(id);
    }
}
