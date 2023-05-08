package com.java.test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionEntity {
    @Id
    private int id;
    private String answer;
    private String question;
    private int value;
    private String airdate;
    private String created_at;
    private String updated_at;
    private int game_id;
    private Integer invalid_count;
    private int category_id;
}
