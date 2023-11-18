package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    void create(Account form);

    void update(Account form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
