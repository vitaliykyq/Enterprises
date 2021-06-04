package edu.coursework.enterprises.service.brigade.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;

import java.util.List;

public interface IBrigadeService {

    Brigade getById(String id);
    Brigade create(Brigade brigade);
    Brigade update(Brigade brigade);
    Brigade delete(String id);
    List<Brigade> getAll();
}
