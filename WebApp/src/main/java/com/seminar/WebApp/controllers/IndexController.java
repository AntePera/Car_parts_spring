package com.seminar.WebApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.seminar.WebApp.services.IndexService;


@Controller
public class IndexController {
    
@Autowired
IndexService service;

    @GetMapping("")
    public String index()
    {
        return service.index();
    }

}
