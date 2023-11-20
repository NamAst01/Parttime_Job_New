package com.vti.Part_time_Job.specification;

import com.vti.Part_time_Job.entity.JobDetail;
import com.vti.Part_time_Job.form.JobDetailFilterForm;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JobDetailSpecification {
    public static Specification<JobDetail> buildSpec(JobDetailFilterForm form  ) {
        return (root, query, builder) -> {
            if (form == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>() ;

            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%"+ form.getSearch().trim() + "%" ;

                Path<String> name = root.get("name") ;
                Predicate hasNameLike = builder.like(name, pattern );

                predicates.add(builder.or(hasNameLike)) ;
            }

            if (form.getMinSalary() != null ) {
                Integer pattern = form.getMinSalary();
                Path<Integer> salary = root.get("salary") ;
                Predicate predicate = builder.greaterThanOrEqualTo(salary, pattern) ;

                predicates.add(predicate) ;
            }
            if (form.getMaxSalary() != null ) {
                Integer pattern = form.getMaxSalary() ;
                Path<Integer> salary = root.get("salary") ;
                Predicate predicate = builder.lessThanOrEqualTo(salary, pattern) ;

                predicates.add(predicate) ;
            }
            if (form.getFrom() != null) {
                LocalTime pattern = form.getFrom() ;
                Path<LocalTime> timeFrom = root.get("from") ;
                Predicate predicate = builder.greaterThanOrEqualTo(timeFrom,pattern) ;

                predicates.add(predicate) ;
            }
            if (form.getTo() != null ) {
                LocalTime pattern = form.getTo() ;
                Path<LocalTime> timeTo = root.get("to") ;
                Predicate predicate = builder.lessThanOrEqualTo(timeTo,pattern) ;

                predicates.add(predicate) ;
            }
            if (form.getStatus() != null) {
                String pattern = "%" + form.getStatus() + "%" ;
                Path<String> status = root.get("status") ;
                Predicate hasStatus = builder.like(status, pattern) ;

                predicates.add(hasStatus) ;
            }
            return builder.and(predicates.toArray(new Predicate[0])) ;
        };
    }
}
