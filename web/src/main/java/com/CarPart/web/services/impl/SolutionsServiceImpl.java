package com.CarPart.web.services.impl;

import com.CarPart.web.models.Solutions;
import com.CarPart.web.repository.SolutionsRepository;
import com.CarPart.web.services.SolutionsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SolutionsServiceImpl implements SolutionsService {
    private SolutionsRepository solutionsRepository;

    public SolutionsServiceImpl(SolutionsRepository solutionsRepository) {
        this.solutionsRepository = solutionsRepository;
    }

    @Override
    public List<Solutions> findAllSolutions() {
        List<Solutions> solutions= solutionsRepository.findAll();
        return solutions;
    }

    @Override
    public Solutions saveSolution(Solutions solution) {
        return solutionsRepository.save(solution);
    }

    @Override
    public Solutions findById(long id) {
        Solutions solutions= solutionsRepository.findById(id).get();
        return solutions;
    }

    @Override
    public void delete(long id) {
        solutionsRepository.deleteById(id);
    }
}
