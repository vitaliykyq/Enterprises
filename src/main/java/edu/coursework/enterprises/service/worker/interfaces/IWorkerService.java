package edu.coursework.enterprises.service.worker.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Worker;

import java.util.List;

public interface IWorkerService {

    Worker getById(String id);
    Worker create(Worker worker);
    Worker update(Worker worker);
    Worker delete(String id);
    List<Worker> getAll();
}
