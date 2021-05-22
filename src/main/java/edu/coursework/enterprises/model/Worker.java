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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "worker")
public class Worker {
    @Id
    private String id;

    private Person person;
    private int experience;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Worker(String id, Person person, int experience) {
        this.id = id;
        this.person = person;
        this.experience = experience;
        this.created_at = new Date();
    }
}
