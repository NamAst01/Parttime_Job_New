package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.form.AuthRegisterForm;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthService extends UserDetailsService {
    void create(AuthRegisterForm form);
}
