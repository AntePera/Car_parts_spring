package com.seminar.WebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.Car;
import com.seminar.WebApp.entities.Issue;
import com.seminar.WebApp.entities.Part;
import com.seminar.WebApp.services.AdminService;

@Controller
@PreAuthorize("hasAuthority('admin')")
public class AdminController {
    
    @Autowired
    AdminService service;

    @GetMapping("/admin")
    public String admin(Model model)
    {
        return service.admin(model);
    }

    @PostMapping("/admin/carAdded")
    public RedirectView carAdded(@ModelAttribute Car car)
    {
        return service.carAdded(car);
    }

    @PostMapping("/admin/issueAdded")
    public RedirectView issueAdded(@ModelAttribute Issue issue)
    {
        return service.issueAdded(issue);
    }

    @PostMapping("/admin/partAdded")
    public RedirectView partAdded(@ModelAttribute Part part)
    {
        return service.partAdded(part);
    }


}
