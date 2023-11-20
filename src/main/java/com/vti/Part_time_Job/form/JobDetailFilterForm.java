package com.vti.Part_time_Job.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Getter
@Setter
public class JobDetailFilterForm {
    private String search ;
    private Integer maxSalary ;
    private  Integer minSalary ;
    private String status ;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime from ;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime to ;
}
