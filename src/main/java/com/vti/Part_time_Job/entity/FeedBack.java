package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "feed_back")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "title")
    private String title ;

    @Column(name = "content")
    private String content ;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt ;

    @OneToOne
    @JoinColumn(name = "application_id",referencedColumnName = "id")
    private JobApplication jobApplication ;


}
