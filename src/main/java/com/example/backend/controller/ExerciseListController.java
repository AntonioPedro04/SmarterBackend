package com.example.backend.controller;

import com.example.backend.model.dto.ExerciseList.ExerciseListDTO;
import com.example.backend.model.entity.ExerciseList;
import com.example.backend.service.ExerciseListService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/exerciseList")
@RequiredArgsConstructor
public class ExerciseListController {

    private final ExerciseListService exerciseListService;

    @GetMapping("")
    public List<ExerciseListDTO> getAllLists(){return exerciseListService.getAllLists();}

    @GetMapping("/currentList")
    public ExerciseListDTO getCurrentList(){return exerciseListService.getCurrentList();}

}
