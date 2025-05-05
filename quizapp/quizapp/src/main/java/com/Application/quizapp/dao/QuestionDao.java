package com.Application.quizapp.dao;

import com.Application.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value="SELECT * FROM question q WHERE q.category= :category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
    List<Question> findRandomByCategory(@Param("category") String category, @Param("numQ") int numQ);

    List<Question> findBydifficultyLevel(String difficultyLevel);
}
