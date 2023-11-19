package com.vti.Part_time_Job.specification;

import com.vti.Part_time_Job.entity.Candidate;
import com.vti.Part_time_Job.form.CandidateFilterForm;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CandidateSpecification {
    public static Specification<Candidate> buildSpec (CandidateFilterForm form) {
        return (root, query, builder) -> {
            if (form == null) {
                return null ;
            }
            List<Predicate> predicates = new ArrayList<>() ;

            //Search name
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%"+ form.getSearch().trim()+"%" ;

                Path<String> phone = root.get("phone") ;
                Predicate hasPhoneLike = builder.like(phone, pattern) ;

                Path<String> address = root.get("address") ;
                Predicate hasAddressLike = builder.like(address, pattern) ;

//                Path<String> name = root.get("account").get("email") ;
//                Predicate hasNameLike = builder.like(name, pattern) ;

                predicates.add(builder.or(hasPhoneLike, hasAddressLike));
            }


            return builder.and(predicates.toArray(new Predicate[0])) ;
        };
        }
    }
