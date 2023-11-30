package com.vti.Part_time_Job.repository;


import com.vti.Part_time_Job.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
