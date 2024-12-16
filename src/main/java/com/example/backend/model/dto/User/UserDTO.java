package com.example.backend.model.dto.User;

import com.example.backend.model.dto.Alternative.AlternativeDTO;
import com.example.backend.model.dto.Answer.AnswerDTO;
import com.example.backend.model.entity.Role;
import com.example.backend.model.entity.Tag;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {
    private  Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String country;
    private Role role;
}
