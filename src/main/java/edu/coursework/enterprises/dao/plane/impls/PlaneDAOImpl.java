package edu.coursework.enterprises.dao.plane.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlaneDAOImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.dao.plane.interfaces.IPlaneDAO;
import edu.coursework.enterprises.data.FakeData;
import edu.coursework.enterprises.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PlaneDAOImpl implements IPlaneDAO {

    @Autowired
    FakeData fakeData;

    @Override
    public Plane getById(String id) {
        return this.getAll().stream()
                .filter(plane -> plane.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Plane create(Plane plane) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        plane.setCreated_at(LocalDateTime.now());
        plane.setId(id);
        this.getAll().add(plane);
        return plane;
    }

    @Override
    public Plane update(Plane plane) {
        Plane updatedPlane = this.getById(plane.getId());
        updatedPlane.setName(plane.getName());
        updatedPlane.setModel(plane.getModel());
        updatedPlane.setCivil(plane.getCivil());
        updatedPlane.setIssue(plane.getIssue());
        updatedPlane.setAircrew(plane.getAircrew());
        updatedPlane.setPayload(plane.getPayload());
        updatedPlane.setHeight(plane.getHeight());
        updatedPlane.setLength(plane.getLength());
        updatedPlane.setWingspan(plane.getWingspan());
        updatedPlane.setCeiling(plane.getCeiling());
        updatedPlane.setModified_at(LocalDateTime.now());
        return updatedPlane;

    }

    @Override
    public Plane delete(String id) {
        Plane plane = this.getById(id);
        this.getAll().remove(plane);
        return plane;
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
