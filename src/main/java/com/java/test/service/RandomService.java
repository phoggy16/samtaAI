package com.java.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.test.Entity.QuestionEntity;
import com.java.test.Repository.QuestionRepo;
import com.java.test.dto.NextQuestionDto;
import com.java.test.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandomService {
    private final QuestionRepo questionRepo;
    private final RestTemplate restTemplate;

    @Bean
    public void randomAPICall(){
        ObjectMapper mapper=new ObjectMapper();
        List<QuestionEntity> questionEntityList=new ArrayList<>();

        for(int i=0;i<5;i++){
            List forObject = restTemplate.getForObject("https://jservice.io/api/random", List.class);
            QuestionEntity questionEntity = mapper.convertValue(forObject.get(0), QuestionEntity.class);
            questionEntityList.add(questionEntity);
        }
        //Batch Save
        questionRepo.saveAll(questionEntityList);
    }

    public QuestionDto play(){
        return getQuestion();
    }

    public NextQuestionDto next(int question_id){

        Optional<QuestionEntity> questionEntity=questionRepo.findById(question_id);
        NextQuestionDto nextQuestionDto=new NextQuestionDto();

        if(questionEntity.isPresent()){
            nextQuestionDto.setCorrect_answer(questionEntity.get().getAnswer());
        }else {
            throw new IllegalArgumentException("Invalid question id");
        }

        nextQuestionDto.setNext_question(getQuestion());

        return nextQuestionDto;
    }

    public QuestionDto getQuestion(){
        //Get Random 1 question
        QuestionEntity questionEntity=questionRepo.getRandomQues();
        return QuestionDto.builder().question_id(questionEntity.getId())
                .question(questionEntity.getQuestion()).build();
    }
}
