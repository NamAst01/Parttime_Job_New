package com.vti.Part_time_Job.dto;

import com.vti.Part_time_Job.controller.CandidateController;
import com.vti.Part_time_Job.entity.JobHistory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CandidateDto extends RepresentationModel<CandidateDto> {
    private Integer id ;
    private String phone ;
    private LocalDate dob ;
    private String address ;
    private String image ;
    private List<JobHistory> jobHistoryList ;
    private Integer accountId;

    public CandidateDto withSelfRel() {
        Link link = linkTo(methodOn(CandidateController.class).findById(id)).withSelfRel() ;
        return add(link) ;
    }
}