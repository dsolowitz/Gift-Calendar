package com.teamnorth.data.db.hibernate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

	public String findByParams(){
		List<Questionnaire> qList = (List<Questionnaire>) repo.findAll();
		Questionnaire form = qList.get(0);
		String ideaList = form.getCategory() + " " + form.getHobbies(); //+ " " + form.getHoliday().replace("'","").replace(" ","") ;
		/*String[] ideas = new String[]{form.getHobbies(),form.getCategory(),form.getHoliday(),form.getGender()};
		List<String> ideaList = Arrays.asList(ideas);*/
		return ideaList;
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
