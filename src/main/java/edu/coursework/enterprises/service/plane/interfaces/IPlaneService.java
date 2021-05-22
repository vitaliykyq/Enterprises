package edu.coursework.enterprises.service.plane.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plane;

import java.util.List;

public interface IPlaneService {

    Plane getById(String id);
    Plane create(Plane plane);
    Plane update(Plane plane);
    Plane delete(String id);
    List<Plane> getAll();
}
