package com.teamnorth.controllers;

import com.teamnorth.data.Event;
import com.teamnorth.data.Questionnaire;
import com.teamnorth.data.db.hibernate.HibernateEventService;
import com.teamnorth.data.db.hibernate.HibernateQuestionnaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


@Controller
public class HomeController {





        @RequestMapping(value="/", method= RequestMethod.GET)
        public ModelAndView index() {
            return new ModelAndView("homepage");
        }

        @RequestMapping(value = "/templates/questionnaire.html", method= RequestMethod.GET)
        public ModelAndView navPage(){
            return new ModelAndView("questionnaire");
        }

        @RequestMapping(value = "/templates/calendar.html", method = RequestMethod.GET)
        public ModelAndView calPage(){
            return new ModelAndView("calendar");
        }

    @RequestMapping(value = "/templates/about.html", method = RequestMethod.GET)
    public ModelAndView aboutPage(){
        return new ModelAndView("about");
    }

    @RequestMapping(value = "/templates/contact.html", method = RequestMethod.GET)
    public ModelAndView contactPage(){
        return new ModelAndView("contact");
    }




    @RestController
        class EventController {

            @Autowired
            HibernateEventService eventRepository;

            @PostMapping(value = "/event")
            public @ResponseBody  void addEvent(@RequestBody Event event) {
                System.out.println(event.toString());

                eventRepository.save(event);

            }

            @RequestMapping(value = "/event", method = RequestMethod.DELETE)
            public void removeEvent(@RequestBody Event event) {
                eventRepository.delete(event);
            }



            @RequestMapping(value="/allevents", method=RequestMethod.GET, produces = {"application/json"})
            public List<Event> allEvents() {
                return eventRepository.findAll();
            }


            @RequestMapping(value = "/templates/ebay.html", method = RequestMethod.GET)
            public ModelAndView ebayPage(){
                return new ModelAndView( "ebay");
            }
        }
    
    @RestController
	class QuestionnaireController {
		/*
		 * Handles Questionnaire posting and repository changes
		 */

		@Autowired
		HibernateQuestionnaireService qRepo;

		@PostMapping(value = "/templates/questionnaire.html")
		public @ResponseBody ModelAndView addQuestionnaire(@RequestParam Map<String, String> body) {
			// Catches errors
			if (body.isEmpty()) {
				// Return user to the questionnaire if errors occur.
				return new ModelAndView("questionnaire");
			}
			// Log additions
			System.out.println(body.toString());
			// Create Questionnaire using body data
			// The hobbies key can potentially not exist in the map and I'm lazy so this is 'a solution'
			String hobbies = "none";
			// If body contains a hobbies key then gather it's data
			if (body.containsKey("hobbies")) {
				hobbies = body.get("hobbies");
			}
			Questionnaire q = new Questionnaire(
					body.get("name"),
					body.get("gender"),
					body.get("age"),
					// Hobbies can potentially be empty, look above
					hobbies,
					body.get("motivation"),
					body.get("pricing"),
					body.get("category"),
					body.get("holiday"),
					body.get("webPreference"),
					body.get("customized"),
					Integer.parseInt(body.get("daysInAdvance"))
					);
			// Save questionnaire POST to qRepo
			qRepo.save(q);
			// Return user to calendar if everything goes as planned.
			return new ModelAndView("redirect:/templates/calendar.html");
		}

		@RequestMapping(value = "/templates/questionnaire.html", method = RequestMethod.DELETE)
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





