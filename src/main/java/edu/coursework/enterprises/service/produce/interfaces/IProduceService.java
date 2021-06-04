package edu.coursework.enterprises.service.produce.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Produce;

import java.util.List;

public interface IProduceService {

    Produce getById(String id);
    Produce create(Produce produce);
    Produce update(Produce produce);
    Produce delete(String id);
    List<Produce> getAll();
}
