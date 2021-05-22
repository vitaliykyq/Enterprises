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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "engineer")
public class Engineer {
    @Id
    private String id;

    private List<Person> personList;
    private int experience;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Engineer(String id, List<Person> personList, int experience) {
        this.id = id;
        this.personList = personList;
        this.experience = experience;
        this.created_at = new Date();
    }
}
