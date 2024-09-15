package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userAnswer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name ="userResponseStatus_id")
    private UserResponseStatus userResponseStatus;

    @ManyToOne
    @JoinColumn(name ="exercise_id")
    private Exercise exercise;

    private String attempt;
}