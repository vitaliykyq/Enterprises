package edu.coursework.enterprises.service.accounting.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Accounting;

import java.util.List;

public interface IAccountingService {

    Accounting getById(String id);
    Accounting create(Accounting accounting);
    Accounting update(Accounting accounting);
    Accounting delete(String id);
    List<Accounting> getAll();
}
