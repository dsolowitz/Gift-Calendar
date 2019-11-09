package com.teamnorth.controllers;

import com.teamnorth.data.Event;
import com.teamnorth.data.db.EventRepository;
import com.teamnorth.data.db.hibernate.HibernateEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HomeController {





        @RequestMapping(value="/", method= RequestMethod.GET)
        public ModelAndView index() {
            return new ModelAndView("homepage");
        }

        @RequestMapping(value = "/templates/nav.html", method= RequestMethod.GET)
        public ModelAndView navPage(){
            return new ModelAndView("nav");
        }

        @RequestMapping(value = "/templates/calendar.html", method = RequestMethod.GET)
        public ModelAndView calPage(){
            return new ModelAndView("calendar");
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

        }
}





