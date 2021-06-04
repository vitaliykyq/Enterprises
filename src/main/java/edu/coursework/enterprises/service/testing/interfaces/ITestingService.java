package edu.coursework.enterprises.service.testing.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Testing;

import java.util.List;

public interface ITestingService {

    Testing getById(String id);
    Testing create(Testing testing);
    Testing update(Testing testing);
    Testing delete(String id);
    List<Testing> getAll();
}
