package edu.coursework.enterprises.service.person.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Person;

import java.util.List;

public interface IPersonService {

    Person getById(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
    List<Person> getAll();
}
