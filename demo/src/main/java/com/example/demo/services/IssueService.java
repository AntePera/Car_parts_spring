package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Issues;
import com.example.demo.entity.Parts;
import com.example.demo.repositories.IssueRepository;

@Service
public class IssueService {
    
    @Autowired
    IssueRepository repository;

    @Autowired
    PartService partService;


    public List<Issues> getAll()
    {
        return repository.findAll();
    }

    public Issues getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO ISSUE PRESENT WITH ID = " + id));
    }

    public Issues add(Issues issue)
    {
        return repository.save(issue);
    }

    public Issues addIssueToPart(int partId,int issueId)
    {
        Parts part = partService.getById(partId);
        Issues issue = getById(issueId);
        part.addIssue(issue);
        partService.add(part);

        return issue;
    }
}
