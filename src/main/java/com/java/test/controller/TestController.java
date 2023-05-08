package com.java.test.controller;

import com.java.test.dto.NextQuestionDto;
import com.java.test.dto.QuestionDto;
import com.java.test.dto.QuestionRequestDto;
import com.java.test.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

    private final RandomService randomService;

    @GetMapping("/play")
    public QuestionDto getQuestion(){
        return randomService.play();
    }

    @PostMapping("/next")
    public NextQuestionDto getQuestion(@RequestBody QuestionRequestDto requestDto){
        return randomService.next(requestDto.getQuestion_id());
    }
}
