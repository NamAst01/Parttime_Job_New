package com.vti.Part_time_Job.controller;


import com.vti.Part_time_Job.form.AuthRegisterForm;
import com.vti.Part_time_Job.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final IAuthService service;

    @Autowired
    public AuthController(IAuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void create(@RequestBody AuthRegisterForm form) {
        service.create(form);
    }


}
