package com.example.backend.model.dto.Question;

import com.example.backend.model.dto.Alternative.AlternativeDTO;
import com.example.backend.model.dto.Answer.AnswerDTO;
import com.example.backend.model.entity.Alternative;
import com.example.backend.model.entity.Answer;
import com.example.backend.model.entity.Exercise;
import com.example.backend.model.entity.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class QuestionDTO {

    private Integer id;

    private String text;

    private List<AlternativeDTO> alternatives;

    private List<AnswerDTO> answers;

    private List<Tag> tags;
}
