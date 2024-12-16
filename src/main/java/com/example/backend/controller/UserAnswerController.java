package com.example.backend.controller;

import com.example.backend.model.custom.IUserTotalPoints;
import com.example.backend.model.custom.UserTotalPoints;
import com.example.backend.model.dto.UserAnswer.GetUserAnswersDTO;
import com.example.backend.model.dto.UserAnswer.PostUserAnswersDTO;
import com.example.backend.model.entity.ExerciseList;
import com.example.backend.model.entity.UserAnswer;
import com.example.backend.service.UserAnswerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userAnswer")
@RequiredArgsConstructor
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    private final UserController userController;


    @PostMapping("/sendAll")
    public List<PostUserAnswersDTO> postUserAnswers(
            @RequestBody List<PostUserAnswersDTO> userAnswerList
    ){
        return userAnswerService.postUserAnswers(userAnswerList);
    }

    @GetMapping("/weekRank")
    public List<IUserTotalPoints> getWeekRankTop3(){
        return userAnswerService.getWeekRankTop3();
    }

    @GetMapping("/userRank")
    public IUserTotalPoints getUserRank(HttpServletRequest request){
         return userAnswerService.getUserWeekRank(request);
    }

    @GetMapping("/{exerciseListId}")
    public List<GetUserAnswersDTO> getUserAnswersByUserAndList(HttpServletRequest request,
                                                               @PathVariable Integer exerciseListId){
        return userAnswerService.getUserAnswersByUserAndList(request, exerciseListId);
    }

}
