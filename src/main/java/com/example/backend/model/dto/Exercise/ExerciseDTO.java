package com.example.backend.model.dto.Exercise;

import com.example.backend.model.dto.Question.QuestionDTO;
import com.example.backend.model.entity.ExerciseList;
import com.example.backend.model.entity.Question;
import com.example.backend.model.entity.UserAnswer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExerciseDTO {

    private Integer id;

    private Integer points;

    private QuestionDTO question;

}
