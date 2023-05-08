package com.java.test.dto;

import lombok.Data;

@Data
public class NextQuestionDto {
    private String correct_answer;
    private QuestionDto next_question;
}
