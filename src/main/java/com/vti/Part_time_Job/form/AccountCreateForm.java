package com.vti.Part_time_Job.form;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.entity.JobHistory;
//import com.vti.Part_time_Job.validation.EmailNotExist;
import com.vti.Part_time_Job.validation.EmailNotExist;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "{AccountForm.email.NotBlank}")
    @EmailNotExist(message = "{AccountForm.email.EmailNotExist}")
    private String email;
    @NotBlank(message = "{AccountForm.password.NotBlank }")
    private String password;
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Role is not Blank")
    private Account.Role role;
    @Pattern(regexp = "ENABLED|BLOCKED|DENIED", message = "Role is Invalid")
    private String status;
    private @Valid CandidateCreateForm candidate;
    private @Valid EmployerCreateFrom employer;

    @Getter
    @Setter
    public class CandidateCreateForm {
        @NotBlank(message = "Phone is not Blank")
        private String phone;
        private LocalDate dob;
        private String address;
        private String image;
    }

    @Getter
    @Setter
    public class EmployerCreateFrom {
        private String company;
        @NotBlank(message = "Email of Company is not Bank ")
        private String emailCompany;
        private String phoneCompany;
        private String position;
        private String image;
        private List<JobDetail> jobDetails;
    }

}
