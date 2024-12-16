package com.example.backend.model.dto.ExerciseList;

import com.example.backend.model.entity.ExerciseList;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ExerciseListGetUserAnswersDTO {

    private Integer id;
    private String name;
    private Date avaiableStartTime;
    private Date avaiableEndTime;
}
