package com.teamnorth.data.db.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.teamnorth.data.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamnorth.data.db.EventRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class HibernateEventService  {
	

	@Autowired
	private EventRepository repo;



	public <S extends Event> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	public Optional<Event> findById(Long aLong) {
		return Optional.empty();
	}


	public boolean existsById(Long aLong) {
		return false;
	}


	public List<Event> findAll() {
		List<Event> events = (List<Event>) repo.findAll();
		return events;
	}


	public Iterable<Event> findAllById(Iterable<Long> longs) {
		return null;
	}


	public long count() {
		return 0;
	}


	public void deleteById(Long aLong) {

	}


	public void save(Event event) {
		repo.save(event);
	}


	public void delete(Event event) {

	}


	public void deleteAll(Iterable<? extends Event> entities) {

	}


	public void deleteAll() {

	}


	public List<Event> findByDatesBetween(Date start, Date end) {
		return null;
	}







}
