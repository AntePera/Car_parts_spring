package com.CarPart.web.controllers;

import com.CarPart.web.models.*;
import com.CarPart.web.services.IssuesService;
import com.CarPart.web.services.PartsService;
import com.CarPart.web.services.SolutionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IssueController  {
    private IssuesService issuesService;
    private SolutionsService solutionsService;
    private PartsService partsService;

    public IssueController(IssuesService issuesService,SolutionsService solutionsService,PartsService partsService) {
        this.issuesService = issuesService;
        this.solutionsService=solutionsService;
        this.partsService=partsService;
    }
    @GetMapping("/issues")
    public String listIssues(Model model){
        List<Issues> issues= issuesService.findAllIssues();
        model.addAttribute("issues",issues);
        return "issuelist";
    }
    @GetMapping("/issues/new")
    public String createIssueForm(Model model){
        Issues issue=new Issues();
        List<Parts>parts=partsService.findAllParts();
        model.addAttribute("issue",issue);
        model.addAttribute("parts",parts);
        return "createissue";
    }
    @PostMapping("/issues/new")
    public String saveIssue(@ModelAttribute("Issue") Issues issue){
        issuesService.saveIssues(issue);
        return "redirect:/issues";
    }
    @GetMapping("/issues/{issuesId}/edit")
    public String EditIssueForm(@PathVariable("issuesId")long issuesId, Model model){
        Issues issue=issuesService.findIssueById(issuesId);
        List<Parts>parts=partsService.findAllParts();
        model.addAttribute("issue",issue);
        model.addAttribute("parts",parts);
        return "editissue";
    }
    @PostMapping("/issues/{issuesId}/edit")
    public String PostIssueForm(@PathVariable("issuesId") long id,  @ModelAttribute("issues") Issues issue) {
        issue.setId(id);
        issue.setPart(issue.getPart());
        issuesService.saveIssues(issue);
        return "redirect:/issues";
    }
    @GetMapping("/issues/{issuesId}/delete")
    public String deleteManufacturer(@PathVariable("issuesId") long id){
        issuesService.delete(id);
        return "redirect:/issues";
    }
    @GetMapping("/issues/search")
    public String searchIssues(@RequestParam(value = "query") String query, Model model) {
        List<Issues> issues = issuesService.searchIssues(query);
        model.addAttribute("issues", issues);
        return "issuelist";
    }
    @GetMapping("/issues/{issueId}")
    public String getSolutionsByIssueId(@PathVariable Long issueId, Model model) {
        List<Solutions> solutions = issuesService.ListIssueSolutions(issueId);
        model.addAttribute("solutions",solutions);
        return "issuesolution";
    }
}
