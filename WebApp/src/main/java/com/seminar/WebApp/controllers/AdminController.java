package com.seminar.WebApp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasAuthority('admin')")
public class AdminController {
    

    @GetMapping("/admin")
    public String admin(Model model)
    {
        return "admin";
    }
}
