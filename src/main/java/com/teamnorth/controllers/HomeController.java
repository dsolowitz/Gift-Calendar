package com.teamnorth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


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
        }

