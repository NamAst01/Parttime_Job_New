package com.vti.Part_time_Job;

import com.vti.Part_time_Job.dto.AccountDto;
import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.AccountCreateForm;
import com.vti.Part_time_Job.form.CandidateCreateForm;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PartTimeJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartTimeJobApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper() ;
		mapper.typeMap(CandidateCreateForm.class, Candidate.class)
				.addMappings(mapping -> mapping.skip(Candidate:: setId) ) ;
		return mapper ;
	}
}
// npx kill-port 8181
