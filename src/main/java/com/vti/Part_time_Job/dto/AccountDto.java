package com.vti.Part_time_Job.dto;

import com.vti.Part_time_Job.controller.AccountController;
import com.vti.Part_time_Job.controller.CandidateController;
import com.vti.Part_time_Job.controller.EmployerController;
import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.entity.JobHistory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class AccountDto extends RepresentationModel<AccountDto>{
    private Integer id ;
    private String email ;
    private String fullName ;
    private LocalDateTime createdAt ;
    private List<Account.Role> roles;

    private Account.Status status ;

    private CandidateDto candidate ;

    private EmployerDto employer ;

    public AccountDto withSelfRel()  {
        if(candidate != null) {
            Link link = linkTo(methodOn(CandidateController.class).findById(candidate.getId())).withSelfRel() ;
            candidate.add(link) ;
        }
        if(employer != null) {
            Link link = linkTo(methodOn(EmployerController.class).findById(employer.getId())).withSelfRel() ;
            employer.add(link) ;
        }
        Link link = linkTo(methodOn(AccountController.class).findById(id)).withSelfRel() ;
        return add(link) ;
    }

    @Getter
    @Setter
    public static class CandidateDto extends RepresentationModel<CandidateDto>{
        private Integer id ;
        private String phone ;
        private LocalDate dob ;
        private String address ;
        private String image ;
        private Integer accountId;

        public CandidateDto withSelfRel()  {
            Link link = linkTo(methodOn(CandidateController.class).findById(id)).withSelfRel() ;
            return add(link) ;
        }
    }
}
