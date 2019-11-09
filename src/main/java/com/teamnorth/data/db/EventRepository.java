package com.teamnorth.data.db;

import com.teamnorth.data.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

}
