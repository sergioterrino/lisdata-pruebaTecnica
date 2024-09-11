package com.lisdatasolutions.lisdata.vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
    List<Vehicle> findByActiveTrue(); 
    List<Vehicle> findByUserId(int userId);
    List<Vehicle> findByUserIdAndActiveTrue(int userId);
    List<Vehicle> findByUserIdAndActiveFalse(int userId);

}
