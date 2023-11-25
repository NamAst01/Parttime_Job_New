package com.vti.Part_time_Job.dto;

import com.vti.Part_time_Job.controller.EmployerController;
import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.JobDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class EmployerDto  extends RepresentationModel<EmployerDto> {
    private Integer id ;
    private String company ;
    private String emailCompany ;
    private String phoneCompany ;
    private String position ;
    private String image ;
    private Integer accountId;
    private List<JobDetail> jobDetails ;

    public EmployerDto withSelfRel()  {
        Link link = linkTo(methodOn(EmployerController.class).findById(id)).withSelfRel() ;
        return add(link) ;
    }
}
