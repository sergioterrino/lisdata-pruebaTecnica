package com.lisdatasolutions.lisdata.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    List<Car> findByActiveTrue();
    List<Car> findByUserIdAndActiveTrue(int userId);
}