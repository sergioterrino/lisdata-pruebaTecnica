package com.lisdatasolutions.lisdata.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
  List<User> findByActiveTrue(); // query method
  // the same but with JPQL
  @Query("SELECT u from User u where u.active = true")
  List<User> findByActiveTrueJPQL();
  // the same but with the native
  @Query(value="SELECT * from user where active = true", nativeQuery=true)
  List<User> findByActiveTrueNative();
}