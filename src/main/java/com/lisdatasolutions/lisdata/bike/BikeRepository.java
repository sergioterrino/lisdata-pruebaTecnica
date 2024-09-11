package com.lisdatasolutions.lisdata.bike;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer>{
    List<Bike> findByActiveTrue();
    List<Bike> findByUserIdAndActiveTrue(int userId);
}