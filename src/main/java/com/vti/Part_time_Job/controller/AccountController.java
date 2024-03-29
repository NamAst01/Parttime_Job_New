package com.vti.Part_time_Job.controller;

import com.vti.Part_time_Job.dto.AccountDto;
import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.form.AccountCreateForm;
import com.vti.Part_time_Job.form.AccountFilterForm;
import com.vti.Part_time_Job.service.IAccountService;
import com.vti.Part_time_Job.validation.AccountIdExist;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    public Page<AccountDto> findAll(AccountFilterForm form,
                                    @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
            ) {
        Page<Account> accounts = service.findAll(form, pageNo, pageSize, sortBy, sortDir);
        return accounts.map(account -> mapper.map(account, AccountDto.class) .withSelfRel());
    }

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable("id")  @AccountIdExist Integer id) {
        return mapper.map(service.findById(id), AccountDto.class)
                .withSelfRel();
    }

    @PostMapping
    public void create(@RequestBody @Valid AccountCreateForm form) {
        service.create(form);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") @AccountIdExist Integer id, @RequestBody Account form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/id")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
