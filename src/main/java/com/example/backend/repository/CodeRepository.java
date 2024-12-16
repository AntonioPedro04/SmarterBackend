package com.example.backend.repository;

import com.example.backend.model.entity.Code;
import com.example.backend.model.entity.ExerciseList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Integer> {

    Optional<Code> findByValue(String value);
}
