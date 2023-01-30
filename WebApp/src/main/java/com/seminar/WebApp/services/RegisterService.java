package com.seminar.WebApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.seminar.WebApp.entities.UserForm;


@Service
public class RegisterService {
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(Model model)
    {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    public String registerSuccess(UserForm userForm)
    {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        restTemplate.postForObject("http://localhost:8080/users", userForm,UserForm.class);

        return "index";
    }

}
