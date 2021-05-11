package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Worker 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Worker {

    private String id;

    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Worker(String id, Person person) {
        this.id = id;
        this.person = person;
        this.created_at = LocalDateTime.now();
    }
}
