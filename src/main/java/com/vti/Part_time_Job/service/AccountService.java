package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.controller.CandidateController;
import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.AccountCreateForm;
import com.vti.Part_time_Job.form.AccountFilterForm;
import com.vti.Part_time_Job.repository.IAccountRepository;
import com.vti.Part_time_Job.repository.ICandidateRepository;
import com.vti.Part_time_Job.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService implements  IAccountService {
    @Autowired
    private IAccountRepository repository ;
    @Autowired
    private ICandidateRepository candidateRepository ;
    @Autowired
    private ModelMapper mapper ;

    @Override
    public Page<Account> findAll(AccountFilterForm form , int pageNo, int pageSize, String sortBy, String sortDir){
        Specification<Account> spec = AccountSpecification.buildSpec(form) ;
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAll(spec , pageable) ;
    }

    @Override
    public Account findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void create(AccountCreateForm form) {

        Account account= mapper.map(form, Account.class) ;
        Candidate candidate = account.getCandidate();
        Employer employer = account.getEmployer() ;

        if (candidate != null ) {
            candidate.setAccount(account);
        }
        if (employer != null ) {
            employer.setAccount(account);
        }

        repository.save(account) ;
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
