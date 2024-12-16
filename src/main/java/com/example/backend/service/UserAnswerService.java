package com.example.backend.service;


import com.example.backend.controller.UserController;
import com.example.backend.model.custom.IUserTotalPoints;
import com.example.backend.model.custom.UserTotalPoints;
import com.example.backend.model.dto.User.UserDTO;
import com.example.backend.model.dto.UserAnswer.GetUserAnswersDTO;
import com.example.backend.model.dto.UserAnswer.PostUserAnswersDTO;
import com.example.backend.model.entity.UserAnswer;
import com.example.backend.repository.ExerciseRepository;
import com.example.backend.repository.UserAnswerRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.UserResponseStatusRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;

    private final UserRepository userRepository;

    private final UserResponseStatusRepository userResponseStatusRepository;

    private final ExerciseRepository exerciseRepository;

    private final UserController userController;

    private final ModelMapper modelMapper;

    public List<PostUserAnswersDTO> postUserAnswers(List<PostUserAnswersDTO> userAnswerList) {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<UserAnswer> userAnswers = userAnswerList.stream().map(userAnswerDTO -> {
                    UserAnswer userAnswer = new UserAnswer();
                    userAnswer.setUser(userRepository.findById(userAnswerDTO.getUserId()).get());
                    userAnswer.setUserResponseStatus(userResponseStatusRepository.findById(userAnswerDTO.getUserResponseStatusId()).get());
                    userAnswer.setUserResponseStatus(userResponseStatusRepository.findById(userAnswerDTO.getUserResponseStatusId()).get());
                    userAnswer.setExercise(exerciseRepository.findById(userAnswerDTO.getExerciseId()).get());
                    userAnswer.setErrors(userAnswerDTO.getErrors());
                    userAnswer.setTimeDone(timestamp);
                    return userAnswer;
                }
        ).collect(Collectors.toList());


        userAnswerRepository.saveAll(userAnswers);
        return userAnswerList;
    }

    public List<IUserTotalPoints> getWeekRankTop3() {
        return userAnswerRepository.getWeekRankTop3();
    }


    public IUserTotalPoints getUserWeekRank(HttpServletRequest request) {
        UserDTO userDTO = userController.getLoggedUser(request);
        List<IUserTotalPoints> userTotalPointsList = userAnswerRepository.getWeekRank();

        IUserTotalPoints userTotalPointsFound = null;

        for (IUserTotalPoints userTotalPoints : userTotalPointsList) {
            if (userTotalPoints.getUserName().equals(userDTO.getUsername())) {
                userTotalPointsFound = userTotalPoints;
                return userTotalPointsFound;
            }
        }

        UserTotalPoints userTotalPointsNotFound = new UserTotalPoints(null, userDTO.getUsername(),
                userDTO.getFirstname(), userDTO.getLastname(), userDTO.getCountry(), 0L);

        userTotalPointsNotFound.setUserName(userDTO.getUsername());
        userTotalPointsNotFound.setCountry(userDTO.getCountry());
        userTotalPointsNotFound.setFirstName(userDTO.getFirstname());
        userTotalPointsNotFound.setLastName(userDTO.getLastname());


        return userTotalPointsNotFound;
    }

    public List<GetUserAnswersDTO> getUserAnswersByUserAndList(HttpServletRequest request, Integer exerciseListId) {
        UserDTO userDTO = userController.getLoggedUser(request);
        List<UserAnswer> userAnswerList = userAnswerRepository.
                findUserAnswersByUserIdAndExerciseListId(userDTO.getId(), exerciseListId);

        return userAnswerList.stream().map(userAnswer -> modelMapper.map(userAnswer, GetUserAnswersDTO.class)).collect(Collectors.toList());
    }
}
