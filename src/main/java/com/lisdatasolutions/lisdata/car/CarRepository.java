package com.lisdatasolutions.lisdata.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
    // Query Methods / Repository Methods
    List<Car> findByActiveTrue();
    List<Car> findByUserIdAndActiveTrue(int userId);

    // JPQL Java Persistence
    @Query("SELECT c FROM Car c WHERE c.active = true")
    List<Car> findActiveCars();
    @Query("SELECT c FROM Car c WHERE c.active = true and c.user.id = :userId")
    List<Car> findActiveCarsByUserId(@Param("userId") int userId);

    // Native Queries
    @Query(value = "SELECT * FROM Car c where c.active = true", nativeQuery = true)
    List<Car> findActiveCarsNative();
    @Query(value = "SELECT * FROM Car c where c.active = true and c.user_id = :userId", nativeQuery = true)
    List<Car> findActiveCarsByUserIdNative(@Param("userId") int userId);
}