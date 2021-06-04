package edu.coursework.enterprises.service.glider.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Glider;

import java.util.List;

public interface IGliderService {

    Glider getById(String id);
    Glider create(Glider glider);
    Glider update(Glider glider);
    Glider delete(String id);
    List<Glider> getAll();
}
