package com.vti.Part_time_Job.form;

import com.vti.Part_time_Job.entity.Account;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthRegisterForm {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Account.Role role;
}
