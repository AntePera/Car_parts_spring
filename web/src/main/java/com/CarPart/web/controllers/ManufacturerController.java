package com.CarPart.web.controllers;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManufacturerController {
    private ManufacturerService manufacturerService;
    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }
    @GetMapping("/manufacturers")
    public String listManufacturers(Model model){
        List<Manufacturer> manufacturers= manufacturerService.findAllManufacturers();
        model.addAttribute("manufacturers",manufacturers);
        return "manlist";
    }
    @GetMapping("/manufacturers/new")
    public String createCarForm(Model model){
        Manufacturer manufacturer=new Manufacturer();
        model.addAttribute("manufacturer",manufacturer);
        return "createman";
    }
    @PostMapping("/manufacturers/new")
    public String saveCar(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }
    @GetMapping("/manufacturers/{manufacturerId}/edit")
    public String EditManufacturerForm(@PathVariable("manufacturerId")long manufacturerId,Model model){
        Manufacturer manufacturer=manufacturerService.findManById(manufacturerId);
        model.addAttribute("manufacturer",manufacturer);
        return "manedit";
    }
    @PostMapping("/manufacturers/{manufacturerId}/edit")
    public String PostManufacturerForm(@PathVariable("manufacturerId") long id, @ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturer.setId(id);
        manufacturerService.saveManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }
    @GetMapping("/manufacturers/{manufacturerId}/delete")
    public String deleteManufacturer(@PathVariable("manufacturerId") long id){
        manufacturerService.delete(id);
        return "redirect:/manufacturers";
    }
    @GetMapping("/manufacturers/search")
    public String searchManufacturer(@RequestParam(value = "query") String query, Model model){
        List<Manufacturer> manufacturers= manufacturerService.searchManufacturers(query);
        model.addAttribute("manufacturers",manufacturers);
        return "manlist";
    }



}
