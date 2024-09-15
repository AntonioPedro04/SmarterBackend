package com.example.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @OneToMany(mappedBy = "question")
    private List<Alternative> alternatives;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @OneToMany(mappedBy = "question")
    private List<Exercise> exercises;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",
                    referencedColumnName = "id"))
    private List<Tag> tags;
}
