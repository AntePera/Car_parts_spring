package com.CarPart.web.services;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Solutions;

import java.util.List;

public interface IssuesService {
    List<Issues> findAllIssues();
    Issues saveIssues(Issues issue);

    Issues findIssueById(long id);

    List<Issues>searchIssues(String query);

    List<Solutions>ListIssueSolutions(long id);
    void delete(long id);
}
