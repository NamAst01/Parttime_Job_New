package com.vti.Part_time_Job.form;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.entity.JobHistory;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AccountCreateForm {

    private String email ;
    private String password ;
    private String firstName ;
    private String lastName ;
    private List<Account.Role> roles;
    private Account.Status status ;
    private CandidateCreateForm candidate ;
    private EmployerCreateFrom employer ;


    @Getter
    @Setter
    public class CandidateCreateForm {
        private String phone ;
        private LocalDate dob ;
        private String address ;
        private String image ;
    }
    @Getter
    @Setter
    public class EmployerCreateFrom {
        private String company ;
        private String emailCompany ;
        private String phoneCompany ;
        private String position ;
        private String image ;
        private List<JobDetail> jobDetails ;
    }

}
