package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_type")
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column(name = "name")
    private String name ;

    @OneToMany(mappedBy = "jobType")
    private List<JobDetail> jobDetails ;
}
