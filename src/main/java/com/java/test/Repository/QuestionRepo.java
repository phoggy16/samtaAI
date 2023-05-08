package com.java.test.Repository;

import com.java.test.Entity.QuestionEntity;
import com.java.test.dto.QuestionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepo extends JpaRepository<QuestionEntity,Integer> {
    //Not Good for large Data Set
    @Query(value = "SELECT * FROM question_entity ORDER BY RAND() LIMIT 1",nativeQuery = true)
    QuestionEntity getRandomQues();
}
