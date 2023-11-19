package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.form.AccountFilterForm;
import com.vti.Part_time_Job.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController  {

    @Autowired
    private IAccountService service ;

    @GetMapping()
    public Page<Account> findAll(AccountFilterForm form,
                                 @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                 @RequestParam(value = "sortBy", defaultValue = "id" , required = false) String sortBy,
                                 @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        return service.findAll(form, pageNo,  pageSize,  sortBy,  sortDir) ;
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
