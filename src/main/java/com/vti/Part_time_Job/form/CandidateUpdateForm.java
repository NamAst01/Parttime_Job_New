package com.vti.Part_time_Job.form;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.JobHistory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CandidateUpdateForm {

    private Integer id ;

    private String phone ;

    private LocalDate dob ;

    private String address ;

    private String image ;

    private List<JobHistory> jobHistoryList ;

}
