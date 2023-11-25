package com.vti.Part_time_Job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;

    @Column(name = "company", nullable = true)
    private String company ;

    @Column(name = "email_company", nullable = true)
    private String emailCompany ;

    @Column(name = "phone_company", nullable = true)
    private String phoneCompany ;

    @Column(name = "position", nullable = true)
    private String position ;

    @Column(name = "image", nullable = true)
    private String image ;

    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private JobDetail jobDetail ;
}
