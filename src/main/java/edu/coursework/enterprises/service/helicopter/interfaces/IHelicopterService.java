package edu.coursework.enterprises.service.helicopter.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Helicopter;

import java.util.List;

public interface IHelicopterService {

    Helicopter getById(String id);
    Helicopter create(Helicopter helicopter);
    Helicopter update(Helicopter helicopter);
    Helicopter delete(String id);
    List<Helicopter> getAll();
}
