package com.vti.Part_time_Job.service;


import com.vti.Part_time_Job.entity.Account;
import com.vti.Part_time_Job.form.AuthRegisterForm;
import com.vti.Part_time_Job.repository.IAuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private final IAuthRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    @Autowired
    public AuthService(IAuthRepository repository, ModelMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }


    @Override
    public void create(AuthRegisterForm form) {
        Account account = mapper.map(form, Account.class);
        String encodedPassword = encoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        repository.save(account);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = repository.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .authorities(account.getRole().toString())
                .build();
    }
//    @Override
//    public void update(String username, AuthRegisterForm form) {
//        Account account = repository.findByUsername(username);
//        if (encoder.matches())
//        repository.save(account) ;
//    }
}
