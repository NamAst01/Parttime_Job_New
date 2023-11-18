package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "content")
    private String content ;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt ;

    @OneToOne
    @JoinColumn(name = "from_account" , referencedColumnName =  "id")
    private Account account ;

    @OneToOne
    @JoinColumn(name = "to_job",referencedColumnName = "id")
    private  JobDetail jobDetail ;
}
