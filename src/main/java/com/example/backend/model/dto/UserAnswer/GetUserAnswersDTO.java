package com.example.backend.model.dto.UserAnswer;

import com.example.backend.model.dto.Exercise.ExerciseGetUserAnswersDTO;
import com.example.backend.model.dto.User.UserDTO;
import com.example.backend.model.dto.UserResponseStatus.UserResponseStatusDTO;
import com.example.backend.model.entity.Exercise;
import com.example.backend.model.entity.User;
import com.example.backend.model.entity.UserResponseStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class GetUserAnswersDTO {

    private Integer id;

    private UserResponseStatusDTO userResponseStatus;

    private ExerciseGetUserAnswersDTO exercise;

    private Integer errors;

    private Date timeDone;
}
