package com.CarPart.web.services.impl;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Solutions;
import com.CarPart.web.repository.IssuesRepository;
import com.CarPart.web.repository.SolutionsRepository;
import com.CarPart.web.services.IssuesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssuesService {

    private IssuesRepository issuesRepository;
    private SolutionsRepository solutionsRepository;


    public IssueServiceImpl(IssuesRepository issuesRepository, SolutionsRepository solutionsRepository) {
        this.issuesRepository = issuesRepository;
        this.solutionsRepository=solutionsRepository;
    }

    @Override
    public List<Issues> findAllIssues() {
        List<Issues>issues=issuesRepository.findAll();
        return issues;
    }

    @Override
    public Issues saveIssues(Issues issue) {
        return issuesRepository.save(issue);
    }

    @Override
    public Issues findIssueById(long id) {
        Issues issues=issuesRepository.findById(id).get();
        return issues;
    }

    @Override
    public List<Issues> searchIssues(String query) {
        List<Issues> issues=issuesRepository.searchIssues(query);
        return issues;

    }

    @Override
    public List<Solutions> ListIssueSolutions(long id) {
          List <Solutions> solutions= solutionsRepository.findByIssueId(id);
          return solutions;
    }

    @Override
    public void delete(long id) {
            issuesRepository.deleteById(id);

    }
}
