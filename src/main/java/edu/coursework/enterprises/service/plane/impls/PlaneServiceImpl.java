package edu.coursework.enterprises.service.plane.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.dao.plane.impls.PlaneDAOImpl;
import edu.coursework.enterprises.data.FakeData;
import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.service.plane.interfaces.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements IPlaneService {

    @Autowired
    FakeData fakeData;

    @Autowired
    PlaneDAOImpl dao;

    @Override
    public Plane getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Plane create(Plane plane) {
        return dao.create(plane);
    }

    @Override
    public Plane update(Plane plane) {
        return dao.update(plane);
    }

    @Override
    public Plane delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Plane save(Plane plane) {
        return null;
    }

    @Override
    public List<Plane> getAll() {
        return fakeData.getPlaneList();
    }
}
