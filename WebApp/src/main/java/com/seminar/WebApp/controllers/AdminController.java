package com.seminar.WebApp.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("/admin/cars/{page}")
    public String adminCars(Model model, @PathVariable("page") int page) { return service.adminCars(model, page); }

    @GetMapping("/admin/parts/{page}")
    public String adminParts(Model model, @PathVariable("page") int page) { return service.adminParts(model, page); }

    @GetMapping("/admin/issues/{page}")
    public String adminIssues(Model model, @PathVariable("page") int page) { return service.adminIssues(model, page); }

    @GetMapping("/admin/issuesToParts")
    public String adminIssuesToParts(Model model) { return service.adminIssuesToParts(model); }

    @GetMapping("/admin/carsToParts")
    public String adminCarsToParts(Model model) { return service.adminCarsToParts(model); }

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
    public RedirectView partAdded(@ModelAttribute Part part, @RequestParam MultipartFile img) throws IOException
    {
        return service.partAdded(part,img);
    }

    @PostMapping("/admin/addIssuesToParts")
    public RedirectView addIssuesToParts(@RequestParam(value="partSelect") int partSelect, @RequestParam(value="issueSelect") String issueSelect)
    {
        return service.addIssuesToParts(partSelect,issueSelect);
    }

    @PostMapping("/admin/addCarsToParts")
    public RedirectView addCarsToParts(@RequestParam(value="partSelect") int partSelect, @RequestParam(value="carSelect") String carSelect)
    {
        return service.addCarsToParts(partSelect,carSelect);
    }


}
