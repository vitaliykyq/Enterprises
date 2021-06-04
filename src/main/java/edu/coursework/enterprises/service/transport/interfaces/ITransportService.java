package edu.coursework.enterprises.service.transport.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Transport;

import java.util.List;

public interface ITransportService {

    Transport getById(String id);
    Transport create(Transport transport);
    Transport update(Transport transport);
    Transport delete(String id);
    List<Transport> getAll();
}
