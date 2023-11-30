package com.vti.Part_time_Job.validation;

import com.vti.Part_time_Job.repository.IAccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailNotExistValidator   implements ConstraintValidator<EmailNotExist,String> {
    @Autowired
    private IAccountRepository repository ;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !repository.existsByEmail(email);    }

}
