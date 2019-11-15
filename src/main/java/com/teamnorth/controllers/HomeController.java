package com.teamnorth.controllers;

import com.teamnorth.data.Event;
import com.teamnorth.data.Questionnaire;
import com.teamnorth.data.db.EventRepository;
import com.teamnorth.data.db.hibernate.HibernateEventService;
import com.teamnorth.data.db.hibernate.HibernateQuestionnaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("homepage");
	}

	@RequestMapping(value = "/questionnaire", method = RequestMethod.GET)
	public ModelAndView questionnairePage() {
		return new ModelAndView("questionnaire");
	}

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView calPage() {
		return new ModelAndView("calendar");
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutPage() {
		return new ModelAndView("about");
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contactPage() {
		return new ModelAndView("contact");
	}

	
	@RestController
	class EventController {
		/*
		 * Handles Event posting and repository changes
		 */

		@Autowired
		HibernateEventService eventRepository;

		@PostMapping(value = "/event")
		public @ResponseBody void addEvent(@RequestBody Event event) {
			System.out.println(event.toString());

			eventRepository.save(event);

		}

		@RequestMapping(value = "/event", method = RequestMethod.DELETE)
		public void removeEvent(@RequestBody Event event) {
			eventRepository.delete(event);
		}

		@RequestMapping(value = "/allevents", method = RequestMethod.GET, produces = { "application/json" })
		public List<Event> allEvents() {
			return eventRepository.findAll();
		}
	}

	
	@RestController
	class QuestionnaireController {
		/*
		 * Handles Questionnaire posting and repository changes
		 */

		@Autowired
		HibernateQuestionnaireService qRepo;

		@PostMapping(value = "/questionnaire")
		public @ResponseBody ModelAndView addQuestionnaire(@RequestBody @Valid Questionnaire q, Errors errors) {
			// Catches errors
			if (errors.hasErrors()) {
				// Return user to the questionnaire if errors occur.
				return new ModelAndView("questionnaire");
			}
			// Log additions
			System.out.println(q.toString());
			// Save questionnaire POST to qRepo
			qRepo.save(q);
			// Return user to calendar if everything goes as planned.
			return new ModelAndView("calendar");
		}

		@RequestMapping(value = "/questionnaire", method = RequestMethod.DELETE)
		// Delete request will attempt to delete supplied Questionnaire
		public void removeQuestionnaire(@RequestBody Questionnaire q) {
			qRepo.delete(q);
		}

		@RequestMapping(value = "/allquestionnaires", method = RequestMethod.GET, produces = { "application/json" })
		// /allquestionnaires will attempt to provide a list of all questionnaires found
		public List<Questionnaire> allQuestionnaires() {
			return qRepo.findAll();
		}
	}
}
