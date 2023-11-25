package com.vti.Part_time_Job.form;

import com.vti.Part_time_Job.entity.JobDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployerUpdateForm {
        private Integer id ;
        private String company ;
        private String emailCompany ;
        private String phoneCompany ;
        private String position ;
        private String image ;
        private List<JobDetail> jobDetails ;
}
