package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "exerciseList")
public class ExerciseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name="workoutPlan_id")
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "exerciseList")
    private List<Exercise> exercises;

}
