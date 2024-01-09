package com.CarPart.web.repository;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepository extends JpaRepository<Issues,Long> {
    @Query("select i from Issues i where i.description like concat('%', :query, '%')")
    List<Issues> searchIssues(String query);
    List<Issues> findByPartId(Long partId);

}
