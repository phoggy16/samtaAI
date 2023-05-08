package com.java.test.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    private int question_id;
    private String question;
}
