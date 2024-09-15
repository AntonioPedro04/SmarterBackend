package com.example.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer points;

    @ManyToOne
    @JoinColumn(name="exerciseList_id")
    private ExerciseList exerciseList;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @OneToMany(mappedBy = "exercise")
    private List<UserAnswer> userAnswers;
}
