package com.teamnorth.data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start")
    private String start;
    @Column(name = "end")
    private String end;

    public Event(int id,String name, String title, String description, String start, String end) {
        super();
        this.name = name;
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public Event() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return end;
    }

    public void setFinish(String end) {
        this.end = end;
    }


    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + " title=" + title + ", description=" + description + ", start=" + start
                + ", end=" + end + "]";
    }
}
