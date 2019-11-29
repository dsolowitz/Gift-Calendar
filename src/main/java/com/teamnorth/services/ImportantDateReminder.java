package com.teamnorth.services;

import com.teamnorth.data.Event;
import com.teamnorth.data.Questionnaire;
import com.teamnorth.data.db.EventRepository;
import com.teamnorth.data.db.QuestionnaireRepository;
import com.teamnorth.data.db.hibernate.HibernateEventService;
import com.teamnorth.data.db.hibernate.HibernateQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ImportantDateReminder {

    private boolean remind = false;

    public Questionnaire getThisQuestaire() {
        return thisQuestaire;
    }

    private Questionnaire thisQuestaire;

    public ImportantDateReminder(){
        remind = getReminder();
    }

    @Autowired
    private HibernateEventService eRepo;
    @Autowired
    private HibernateQuestionnaireService qRepo;

    public boolean getReminder(){
        List<Questionnaire> qList = qRepo.findAll();
        for(Questionnaire questionnaire: qList){
            for(Event event: eRepo.findAll()){
                if(questionnaire.getName().equals(event.getName())){
                    LocalDate imDate = LocalDateTime.parse(event.getStart()).toLocalDate();
                    LocalDate today = LocalDateTime.now().toLocalDate();
                    if(imDate.minusDays(questionnaire.getDaysInAdvance()) == today){
                        if(remind){thisQuestaire = questionnaire;}
                        return remind = true;
                    }

                }
            }

        }

        return false;
    }


}
