package com.example.backend.model.dto.Exercise;

import com.example.backend.model.dto.ExerciseList.ExerciseListGetUserAnswersDTO;
import com.example.backend.model.entity.ExerciseList;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseGetUserAnswersDTO {

    private Integer id;
}
