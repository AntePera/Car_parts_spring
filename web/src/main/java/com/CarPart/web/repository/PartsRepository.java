package com.CarPart.web.repository;

import com.CarPart.web.models.Issues;
import com.CarPart.web.models.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartsRepository extends JpaRepository<Parts,Long> {
    @Query("select p from Parts p where p.name like concat('%', :query, '%')")
    List<Parts> searchParts(String query);
    List<Parts> findByDomesticMarket(String domesticMarket);
}
