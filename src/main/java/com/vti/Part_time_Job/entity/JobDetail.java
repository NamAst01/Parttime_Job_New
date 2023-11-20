package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_detail")
public class JobDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id ;

    @Column(name = "tile")
    private String name ;

    @Column(name = "description")
    private  String description ;

    @Column(name = "salary")
    private int salary ;

    @Column(name = "location")
    private String location ;

    @Column(name = "deadline")
    private LocalDateTime deadline ;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt ;

    //Time of job : from 19:59:59.999999999 to 23:59:59.999999999
    @Column(name = "from")
    private LocalTime from ;

    @Column(name = "to")
    private LocalTime to ;

    @Column(name = "requirement")
    private String requirement ;

    @Column(name = "status", length = 10, nullable = true)
    @Enumerated(value = EnumType.STRING)
    private Status status ;

    @ManyToOne
    @JoinColumn(name = "job_type_id" , referencedColumnName = "id")
    private JobType jobType ;

    @OneToOne
    @JoinColumn(name = "employer_id",referencedColumnName = "id")
    private Employer employer ;

    @OneToMany(mappedBy = "jobDetail")
    private List<JobApplication> jobApplications ;

    @OneToMany(mappedBy = "jobDetail")
    private List<Report> reports ;

    @OneToOne(mappedBy = "jobDetail")
    private Comment comment ;

    public enum Status {
        PUBLISHED ,EXPIRED
    }


}
