package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Engineer 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Engineer {

    private String id;

    private List<Person> persons;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Engineer(String id, List<Person> persons) {
        this.id = id;
        this.persons = persons;
        this.created_at = LocalDateTime.now();
    }
}
