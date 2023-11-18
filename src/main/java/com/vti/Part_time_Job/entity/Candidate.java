package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "phone")
    private String phone ;

    @Column(name = "dob")
    private LocalDate dob ;

    @Column(name = "address")
    private String address ;

    @Column(name = "image")
    private String image ;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL )
    private List<JobHistory> jobHistoryList ;

    @OneToOne(mappedBy = "candidate")
    private Account account;
}
