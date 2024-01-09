package com.CarPart.web.controllers;

import com.CarPart.web.models.*;
import com.CarPart.web.services.CarsService;
import com.CarPart.web.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarsController {

    private CarsService carsService;
    private ManufacturerService manufacturerService;

    @Autowired
    public CarsController(CarsService carsService, ManufacturerService manufacturerService) {
        this.carsService = carsService;
        this.manufacturerService=manufacturerService;
    }
    @GetMapping("/cars")
    public String listCars(Model model){
        List<Cars> cars= carsService.findAllCars();
        model.addAttribute("cars",cars);
        return "carlist";
    }
    @GetMapping("/cars/new")
    public String createCarForm(Model model){
        Cars car=new Cars();
        List<Manufacturer> manufacturer= manufacturerService.findAllManufacturers();
        model.addAttribute("car",car);
        model.addAttribute("manufacturer",manufacturer);
        return "createcar";
    }
    @PostMapping("/cars/new")
    public String saveCar(@ModelAttribute("car") Cars car){
        carsService.saveCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/cars/search")
    public String searchCars(@RequestParam(value = "query") String query, Model model){
        List<Cars> cars= carsService.searchCars(query);
        model.addAttribute("cars",cars);
        return "carlist";
    }

    @GetMapping("/cars/{carId}/edit")
    public String EditSolutionForm(@PathVariable("carId") long id, Model model){
        Cars car= carsService.findById(id);
        List<Manufacturer>manufacturers= manufacturerService.findAllManufacturers();
        model.addAttribute("car",car);
        model.addAttribute("manufacturers",manufacturers);
        return "editcars";
    }
    @PostMapping("/cars/{carId}/edit")
    public String PostSolutionForm(@PathVariable("carId") long id, @ModelAttribute("car") Cars cars) {
        cars.setId(id);
        cars.setManufacturer(cars.getManufacturer());
        carsService.saveCar(cars);
        return "redirect:/cars";
    }
    @GetMapping("/cars/{carId}/delete")
    public String deleteSolutions(@PathVariable("carId") long id){
        carsService.delete(id);
        return "redirect:/cars";
    }



}
