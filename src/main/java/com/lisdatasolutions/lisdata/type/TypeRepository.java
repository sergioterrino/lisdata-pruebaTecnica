package com.lisdatasolutions.lisdata.type;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    Optional<Type> findByDescription(String description);
}