package com.CarPart.web.controllers;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Solutions;
import com.CarPart.web.services.IssuesService;
import com.CarPart.web.services.SolutionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SolutionsController {
    private SolutionsService solutionsService;
    private IssuesService issuesService;

    public SolutionsController(SolutionsService solutionsService, IssuesService issuesService) {
        this.solutionsService = solutionsService;
        this.issuesService= issuesService;
    }
    @GetMapping("/solutions")
    public String listSolutions(Model model){
        List<Solutions> solutions= solutionsService.findAllSolutions();
        model.addAttribute("solutions",solutions);
        return "solutionlist";
    }
    @GetMapping("/solutions/new")
    public String createSolutionForm(Model model){
        Solutions solution=new Solutions();
        List<Issues>issues= issuesService.findAllIssues();
        model.addAttribute("solutions",solution);
        model.addAttribute("issues",issues);
        return "createsolution";
    }
    @PostMapping("/solutions/new")
    public String saveSolution(@ModelAttribute("solution") Solutions solutions){
       solutionsService.saveSolution(solutions);
        return "redirect:/solutions";
    }
    @GetMapping("/solutions/{solutionId}/edit")
    public String EditSolutionForm(@PathVariable("solutionId") long id, Model model){
        Solutions solution= solutionsService.findById(id);
        List<Issues>issues= issuesService.findAllIssues();
        model.addAttribute("solution",solution);
        model.addAttribute("issues",issues);
        return "editsolution";
    }
    @PostMapping("/solutions/{solutionId}/edit")
    public String PostSolutionForm(@PathVariable("solutionId") long id, @ModelAttribute("solution") Solutions solutions) {
        solutions.setId(id);
        solutions.setIssue(solutions.getIssue());
        solutionsService.saveSolution(solutions);
        return "redirect:/solutions";
    }
    @GetMapping("/solutions/{solutionId}/delete")
    public String deleteSolutions(@PathVariable("solutionId") long id){
        solutionsService.delete(id);
        return "redirect:/solutions";
    }

}
