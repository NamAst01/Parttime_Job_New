package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "title")
    private String title ;

    @Column(name = "content")
    private String content ;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account ;

    @ManyToOne
    @JoinColumn(name = "job_detail_id",referencedColumnName = "id")
    private JobDetail jobDetail ;
}
