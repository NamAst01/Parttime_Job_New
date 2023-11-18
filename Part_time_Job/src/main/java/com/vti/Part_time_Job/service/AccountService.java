package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements  IAccountService {
    @Autowired
    private IAccountRepository repository ;

    @Override
    public List<Account> findAll(){
        return repository.findAll() ;
    }

    @Override
    public Account findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Account form) {
        repository.save(form) ;
    }

    @Override
    public void update(Account form) {
        repository.save(form) ;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
