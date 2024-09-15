package com.example.backend.service;

import com.example.backend.model.dto.ExerciseList.ExerciseListDTO;
import com.example.backend.model.entity.ExerciseList;
import com.example.backend.repository.ExerciseListRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseListService {

    private final ExerciseListRepository exerciseListRepository;

    private final ModelMapper modelMapper;
    public List<ExerciseListDTO> getAllLists() {

        List<ExerciseList> exerciseLists = exerciseListRepository.findAll();

        return exerciseLists.stream().map(exerciseList ->{
            ExerciseListDTO exerciseListDTO = new ExerciseListDTO();
            modelMapper.map(exerciseList,exerciseListDTO);
            return exerciseListDTO;
        }).collect(Collectors.toList());
    }

    public ExerciseListDTO getCurrentList() {

        TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        ExerciseList exerciseList = exerciseListRepository.getCurrentList(timestamp);
        ExerciseListDTO exerciseListDTO = new ExerciseListDTO();
        modelMapper.map(exerciseList, exerciseListDTO);

        return exerciseListDTO;
    }
}
