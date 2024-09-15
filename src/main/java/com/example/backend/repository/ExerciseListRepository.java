package com.example.backend.repository;

import com.example.backend.model.entity.ExerciseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;


@Repository
public interface ExerciseListRepository extends JpaRepository<ExerciseList, Integer> {

     @Query(value = "select el from ExerciseList el where :utcDate between el.avaiableStartTime and el.avaiableEndTime")
     ExerciseList getCurrentList(Timestamp utcDate);
}
