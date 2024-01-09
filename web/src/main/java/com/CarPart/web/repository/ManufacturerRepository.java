package com.CarPart.web.repository;

import com.CarPart.web.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    @Query("select m from Manufacturer m where m.name like concat('%', :query, '%')")
    List<Manufacturer> searchManufacturers(String query);

}
