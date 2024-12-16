package com.example.backend.model.dto.UserAnswer;

import lombok.Data;

@Data
public class PostUserAnswersDTO {

    private Integer userId;
    private Integer userResponseStatusId;
    private Integer errors;
    private Integer exerciseId;

}
