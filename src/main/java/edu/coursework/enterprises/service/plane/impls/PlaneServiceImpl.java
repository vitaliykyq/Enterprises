package edu.coursework.enterprises.service.plane.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.repository.PlaneRepository;
import edu.coursework.enterprises.service.plane.interfaces.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlaneServiceImpl implements IPlaneService {

    @Autowired
    PlaneRepository repository;

    @Override
    public Plane getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Plane create(Plane plane) {
        plane.setCreated_at(new Date());
        return repository.save(plane);
    }

    @Override
    public Plane update(Plane plane) {
        plane.setModified_at(new Date());
        return repository.save(plane);
    }

    @Override
    public Plane delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Plane> getAll() {

        return repository.findAll();
    }
}
