package com.CarPart.web.services.impl;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Parts;
import com.CarPart.web.repository.IssuesRepository;
import com.CarPart.web.repository.PartsRepository;
import com.CarPart.web.services.PartsService;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {

    private PartsRepository partsRepository;
    private IssuesRepository issuesRepository;
    public PartsServiceImpl(PartsRepository partsRepository, IssuesRepository issuesRepository) {
        this.partsRepository = partsRepository;
        this.issuesRepository = issuesRepository;
    }

    @Override
    public List<Parts> findAllParts() {
        List<Parts>parts=partsRepository.findAll();
        return parts;
    }

    @Override
    public Parts saveParts(Parts part) {
        return partsRepository.save(part);
    }

    @Override
    public Parts findPartById(long id) {
        Parts part= partsRepository.findById(id).get();
        return part;
    }

    @Override
    public List<Parts> searchParts(String query) {
        List<Parts> parts=partsRepository.searchParts(query);
        return parts;
    }

    @Override
    public List<Issues> ListIssues(long id) {
        List<Issues> issues = issuesRepository.findByPartId(id);
        return issues;
    }

    @Override
    public List<Parts> findParts(String domesticMarket) {
        List<Parts> parts= partsRepository.findByDomesticMarket(domesticMarket);
        return parts;
    }

    @Override
    public void delete(long id) {
        partsRepository.deleteById(id);
    }
}
