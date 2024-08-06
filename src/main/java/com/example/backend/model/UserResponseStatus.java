package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "userResponseStatus")
public class UserResponseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

    private Integer code;

    @OneToMany(mappedBy = "userResponseStatus")
    private List<UserAnswer> userAnswers;
}
