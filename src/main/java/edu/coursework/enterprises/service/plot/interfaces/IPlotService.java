package edu.coursework.enterprises.service.plot.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plot;

import java.util.List;

public interface IPlotService {

    Plot getById(String id);
    Plot create(Plot plot);
    Plot update(Plot plot);
    Plot delete(String id);
    List<Plot> getAll();
}
