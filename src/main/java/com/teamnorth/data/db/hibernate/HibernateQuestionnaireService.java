package com.teamnorth.data.db.hibernate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamnorth.data.Questionnaire;
import com.teamnorth.data.db.QuestionnaireRepository;

@Service
public class HibernateQuestionnaireService {
	
	@Autowired
	private QuestionnaireRepository repo;
	
	public <S extends Questionnaire> Iterable<S> saveAll(Iterable<S> entities) {
		for (Questionnaire q : entities) {
			save(q);
		}
		return entities;
	}
	
	public Optional<Questionnaire> findById(Long aLong) {
		return Optional.empty();
	}
	
	public boolean existsById(Long aLong) {
		return false;
	}
	
	public List<Questionnaire> findAll() {
		List<Questionnaire> qList = (List<Questionnaire>) repo.findAll();
		return qList;
	}
	
	public long count() {
		return findAll().size();
	}

	public void save(Questionnaire q) {
		repo.save(q);
	}
	
	public void delete(Questionnaire q) {
		repo.delete(q);
	}

}
