package edu.coursework.enterprises.dao.plane.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IPlaneDAO
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plane;

import java.util.List;

public interface IPlaneDAO {

    Plane getById(String id);
    Plane create(Plane plane);
    Plane update(Plane plane);
    Plane delete(String id);
    Plane save(Plane plane);
    List<Plane> getAll();
}
