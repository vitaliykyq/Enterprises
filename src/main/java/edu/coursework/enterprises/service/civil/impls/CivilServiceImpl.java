package edu.coursework.enterprises.service.civil.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.dao.civil.impls.CivilDAOImpl;
import edu.coursework.enterprises.data.FakeData;
import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.service.civil.interfaces.ICivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilServiceImpl implements ICivilService {

    @Autowired
    FakeData fakeData;

    @Autowired
    CivilDAOImpl dao;

    @Override
    public Civil getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Civil create(Civil civil) {
        return dao.create(civil);
    }

    @Override
    public Civil update(Civil civil) {
        return dao.update(civil);
    }

    @Override
    public Civil delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Civil save(Civil civil) {
        return null;
    }

    @Override
    public List<Civil> getAll() {
        return fakeData.getCivilList();
    }
}
