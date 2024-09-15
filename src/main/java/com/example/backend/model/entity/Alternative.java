package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="alternative")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
