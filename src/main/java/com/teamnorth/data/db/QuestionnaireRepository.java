package com.teamnorth.data.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teamnorth.data.Questionnaire;

@Repository
public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {

}
