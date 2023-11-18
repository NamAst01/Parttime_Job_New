package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "job_history")
public class JobHistory {
    @Id
    @Column(name = "id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate ;

    @Column(name = "title")
    private String title ;

    @Column(name = "company")
    private String company ;

    @Column(name = "from")
    private LocalDate from ;

    @Column(name = "to")
    private LocalDate to ;

    @Column(name = "description")
    private String description ;

}
