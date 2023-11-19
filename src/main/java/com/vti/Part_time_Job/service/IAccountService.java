package com.vti.Part_time_Job.service;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> findAll(AccountFilterForm form , int pageNo, int pageSize, String sortBy, String sortDir);

    Account findById(Integer id);

    void create(Account form);

    void update(Account form);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);

}
