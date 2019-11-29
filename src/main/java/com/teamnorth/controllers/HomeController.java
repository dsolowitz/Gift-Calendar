package com.teamnorth.controllers;

import com.ebay.api.client.auth.oauth2.CredentialUtil;
import com.ebay.api.client.auth.oauth2.OAuth2Api;
import com.ebay.api.client.auth.oauth2.model.AccessToken;
import com.ebay.api.client.auth.oauth2.model.Environment;
import com.ebay.api.client.auth.oauth2.model.OAuthResponse;
import com.teamnorth.data.Event;
import com.teamnorth.data.Questionnaire;
import com.teamnorth.data.db.hibernate.HibernateEventService;
import com.teamnorth.data.db.hibernate.HibernateQuestionnaireService;

import com.teamnorth.services.ImportantDateReminder;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;


@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("homepage");
    }

    @RequestMapping(value = "/templates/questionnaire.html", method = RequestMethod.GET)
    public ModelAndView navPage() {
        return new ModelAndView("questionnaire");
    }

    @RequestMapping(value = "/templates/calendar.html", method = RequestMethod.GET)
    public ModelAndView calPage() {
        return new ModelAndView("calendar");
    }

    @RequestMapping(value = "/templates/about.html", method = RequestMethod.GET)
    public ModelAndView aboutPage() {
        return new ModelAndView("about");
    }

    @RequestMapping(value = "/templates/contact.html", method = RequestMethod.GET)
    public ModelAndView contactPage() {
        return new ModelAndView("contact");
    }


    @RestController
    class EventController {

        @Autowired
        HibernateEventService eventRepository;


        @PostMapping(value = "/event")
        public @ResponseBody
        void addEvent(@RequestBody Event event) {
            System.out.println(event.toString());

            eventRepository.save(event);

        }

        @RequestMapping(value = "/event", method = RequestMethod.DELETE)
        public void removeEvent(@RequestBody Event event) {
            eventRepository.delete(event);
        }


        @RequestMapping(value = "/allevents", method = RequestMethod.GET, produces = {"application/json"})
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

        @Autowired
        ImportantDateReminder reminder;


        @PostMapping(value = "/templates/questionnaire.html")
        public @ResponseBody
        ModelAndView addQuestionnaire(@RequestParam Map<String, String> body, @RequestParam(name = "hobbies") String[] hobby) {
            // Catches errors

            if (body.isEmpty()) {
                // Return user to the questionnaire if errors occur.
                return new ModelAndView("questionnaire");
            }
            // Log additions
            // Create Questionnaire using body data
            // The hobbies key can potentially not exist in the map and I'm lazy so this is 'a solution'
            String hobbies = null;
            if (hobby.length == 0) {
                hobbies = "none";
            }
            // If body contains a hobbies key then gather it's data
            if (hobby.length > 0) {
                hobbies = "";
                for (int x = 0; x < hobby.length; x++) {
                    hobbies += hobby[x] + " ";
                }
            }
            String hobbies1 = hobbies.replaceAll("&", "").replaceAll("  ", " ");
            System.out.println(hobbies1);
            Questionnaire q = new Questionnaire(
                    body.get("name"),
                    body.get("gender"),
                    body.get("age"),
                    // Hobbies can potentially be empty, look above
                    hobbies1,
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

        @RequestMapping(value = "/allquestionnaires", method = RequestMethod.GET, produces = {"application/json"})
        // /allquestionnaires will attempt to provide a list of all questionnaires found
        public List<Questionnaire> allQuestionnaires() {
            return qRepo.findAll();
        }


        @RequestMapping(value = "/templates/ebay.html", method = RequestMethod.GET)
        public ModelAndView ebayPage() throws IOException {

            return new ModelAndView("ebay");
        }

        @RequestMapping(value = "/giftstring", method = RequestMethod.GET)
        public String getGiftString() {
            Questionnaire qAirre = reminder.getThisQuestaire();
            String params = qRepo.findByParams(qAirre);
            return params;
        }

        @RequestMapping(value = "/giftidea", method = RequestMethod.GET)
        public String giftIdea() {
            boolean remind = reminder.getReminder();
            return "1";
          /*  if (remind) {
                return "1";
            }
            return "0";*/
        }
    }
}





