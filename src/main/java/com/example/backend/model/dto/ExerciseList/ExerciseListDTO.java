package com.example.backend.model.dto.ExerciseList;

import com.example.backend.model.dto.Exercise.ExerciseDTO;
import com.example.backend.model.entity.Exercise;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExerciseListDTO {

    private String name;

    private List<ExerciseDTO> exercises;

    private Date avaiableStartTime;

    private Date avaiableEndTime;
}
