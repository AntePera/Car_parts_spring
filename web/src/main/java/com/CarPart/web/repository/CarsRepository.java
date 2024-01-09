package com.CarPart.web.repository;

import com.CarPart.web.models.Cars;
import com.CarPart.web.models.Manufacturer;
import com.CarPart.web.models.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository <Cars,Long> {
    @Query("select c from Cars c where c.manufacturer.name like concat('%', :query, '%')")
    List<Cars> searchCars(String query);


}
