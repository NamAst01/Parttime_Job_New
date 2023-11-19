package com.vti.Part_time_Job.specification;

import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.AccountFilterForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec (AccountFilterForm form) {
        return (root, query, builder) -> {
            if (form == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>() ;

            return  builder.and(predicates.toArray(new Predicate[0])) ;
        };
    }
}
