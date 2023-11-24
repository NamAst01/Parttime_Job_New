package com.vti.Part_time_Job.specification;

import com.vti.Part_time_Job.entity.Employer;
import com.vti.Part_time_Job.form.EmployerFilterForm;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployerSpecification {
    public static Specification<Employer> buildSpec(EmployerFilterForm form) {
        return (root, query, builder) ->
        {
            List<Predicate> predicates = new ArrayList<>() ;

            if (form != null) {
                return null ;
            }

            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%"+ form.getSearch().trim()+"%" ;

                Path<String> companyName = root.get("company") ;
                Predicate hasCompanyNameLike = builder.like(companyName, pattern) ;

                Path<String> email = root.get("emailCompany") ;
                Predicate hasEmailLike = builder.like(email,pattern) ;

                Path<String> phone = root.get("phoneCompany") ;
                Predicate hasPhoneLike = builder.like(phone,pattern) ;

                predicates.add(builder.or(hasCompanyNameLike, hasPhoneLike, hasEmailLike));
            }

            return builder.and(predicates.toArray(new Predicate[0])) ;
        }  ;
    }
}
