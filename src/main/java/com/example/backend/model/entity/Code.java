package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "code")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

    private Integer curQuantity;

    private Integer maxQuantity;

    @OneToMany(mappedBy = "code")
    private List<User> users;
}
