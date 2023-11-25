package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "email" ,unique = true, nullable = false,updatable = true)
    private String email ;

    @Column(name = "password", length = 70 , nullable = true)
    private String password ;

    @Column(name = "first_name", length = 50,nullable = false)
    private String firstName ;

    @Column(name = "last_name", length = 50 , nullable = false)
    private String lastName ;

    @Formula("concat(first_name,' ',last_name)")
    private String fullName ;

    @CreationTimestamp
    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt ;

    @Column(name = "roles", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private List<Role> roles;

    @Column(name = "status", length = 8, nullable = true)
    @Enumerated(value = EnumType.STRING)
    private Status status ;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Candidate candidate;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Employer employer;

    @OneToMany(mappedBy = "account")
    private List<Report> reports ;

    @OneToOne(mappedBy = "account")
    private Comment comment ;

    public enum Status {
        ENABLED,BLOCKED ,DENIED
    }

    public enum Role {
        ADMIN, STAFF, EMPLOYER, CANDIDATE
    }
}
