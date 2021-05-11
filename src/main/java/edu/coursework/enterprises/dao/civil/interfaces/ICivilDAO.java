package edu.coursework.enterprises.dao.civil.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilDAO 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Civil;

import java.util.List;

public interface ICivilDAO {

    Civil getById(String id);
    Civil create(Civil civil);
    Civil update(Civil civil);
    Civil delete(String id);
    Civil save(Civil civil);
    List<Civil> getAll();
}
