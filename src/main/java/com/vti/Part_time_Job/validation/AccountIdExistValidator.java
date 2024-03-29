package com.vti.Part_time_Job.validation;

import com.vti.Part_time_Job.repository.IAccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountIdExistValidator  implements ConstraintValidator<AccountIdExist,Integer> {
    @Autowired
    private IAccountRepository repository ;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        return repository.existsById(id);
    }
}
