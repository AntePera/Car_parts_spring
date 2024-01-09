package com.CarPart.web.repository;

import com.CarPart.web.models.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionsRepository extends JpaRepository<Solutions,Long> {
    List<Solutions> findByIssueId(Long issueId);
}
