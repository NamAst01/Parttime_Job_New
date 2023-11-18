package com.vti.Part_time_Job.repository;

import com.vti.Part_time_Job.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

}