package com.seminar.WebApp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }
}
