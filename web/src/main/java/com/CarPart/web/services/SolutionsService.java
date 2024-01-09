package com.CarPart.web.services;

import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Solutions;

import java.util.List;

public interface SolutionsService  {
    List<Solutions> findAllSolutions();
    Solutions saveSolution(Solutions solution);
    Solutions findById(long id);

    void delete(long id);
}
