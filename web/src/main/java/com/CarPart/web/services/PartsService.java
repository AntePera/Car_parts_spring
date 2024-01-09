package com.CarPart.web.services;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Parts;
import com.CarPart.web.models.Solutions;

import java.util.List;

public interface PartsService {

    List<Parts> findAllParts();
    Parts saveParts(Parts part);

    Parts findPartById(long id);

    List<Parts>searchParts(String query);

    List<Issues>ListIssues(long id);
    List<Parts>findParts(String domesticMarket);
    void delete(long id);
}
