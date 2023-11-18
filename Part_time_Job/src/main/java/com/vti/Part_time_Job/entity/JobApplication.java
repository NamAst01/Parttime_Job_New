package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "job_application")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;


    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt ;

    @Column(name = "status", length = 8, nullable = true)
    @Enumerated(value = EnumType.STRING)
    private Status status ;

    @ManyToOne
    @JoinColumn(name = "job_detail_id" , referencedColumnName = "id")
    private JobDetail jobDetail ;

    @OneToOne(mappedBy = "jobApplication")
    private FeedBack feedBack ;
    public enum Status {
        APPLIED, APPROVED ,REJECTED
    }


}
