package com.CarPart.web.controllers;

import com.CarPart.web.models.*;
import com.CarPart.web.services.IssuesService;
import com.CarPart.web.services.PartsService;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PartsController {
    private PartsService partsService;
    private IssuesService issuesService;

    public PartsController(PartsService partsService, IssuesService issuesService) {
        this.partsService = partsService;
        this.issuesService = issuesService;
    }
    @GetMapping("/parts")
    public String listParts(Model model){
        List<Parts> parts= partsService.findAllParts();
        model.addAttribute("parts",parts);
        return "partlist";
    }
    @GetMapping("/parts/new")
    public String createPartForm(Model model){
        Parts part=new Parts();
        List<Issues> issues= issuesService.findAllIssues();
        model.addAttribute("part",part);
        model.addAttribute("issues",issues);
        return "createpart";
    }
    @PostMapping("/parts/new")
    public String savePart(@ModelAttribute("part") Parts part){
        partsService.saveParts(part);
        return "redirect:/parts";
    }
    @GetMapping("/parts/search")
    public String searchParts(@RequestParam(value = "query") String query, Model model){
        List<Parts> parts= partsService.searchParts(query);
        model.addAttribute("parts",parts);
        return "partlist";
    }
    @GetMapping("/parts/{partsId}/edit")
    public String EditPartForm(@PathVariable("partsId")long partsId, Model model){
        Parts part=partsService.findPartById(partsId);
        List<Issues> issues=issuesService.findAllIssues();
        model.addAttribute("part",part);
        model.addAttribute("issues",issues);
        return "editpart";
    }
    @PostMapping("/parts/{partsId}/edit")
    public String PostPartForm(@PathVariable("partsId") long id, @ModelAttribute("parts") Parts part) {
        part.setId(id);
        partsService.saveParts(part);
        return "redirect:/parts";
    }
    @GetMapping("/parts/{partsId}/delete")
    public String deletePart(@PathVariable("partsId") long id){
        partsService.delete(id);
        return "redirect:/parts";
    }
    @GetMapping("/parts/{partsId}")
    public String getIssuesByPartId(@PathVariable Long partsId, Model model) {
        List<Issues> issues = partsService.ListIssues(partsId);
        model.addAttribute("issues",issues);
        return "partissue";
    }
    @GetMapping("/parts/filter/{domesticMarket}")
    public String getByMarket(@PathVariable String domesticMarket, Model model){
        List<Parts> parts=partsService.findParts(domesticMarket);
        model.addAttribute("parts",parts);
        return "filterpart";
    }
}
