package edu.coursework.enterprises.dao.civil.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilDAOImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.dao.civil.interfaces.ICivilDAO;
import edu.coursework.enterprises.data.FakeData;
import edu.coursework.enterprises.model.Civil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CivilDAOImpl implements ICivilDAO {

    @Autowired
    FakeData fakeData;

    @Override
    public Civil getById(String id) {
        return this.getAll().stream()
                .filter(civil -> civil.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Civil create(Civil civil) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        civil.setCreated_at(LocalDateTime.now());
        civil.setId(id);
        this.getAll().add(civil);
        return civil;
    }

    @Override
    public Civil update(Civil civil) {
        Civil updatedCivil = this.getById(civil.getId());
        updatedCivil.setBusiness(civil.getIsBusiness());
        updatedCivil.setSeats(civil.getSeats());
        updatedCivil.setBaggage(civil.getIsBaggage());
        updatedCivil.setModified_at(LocalDateTime.now());

        return updatedCivil;

    }

    @Override
    public Civil delete(String id) {
        Civil civil = this.getById(id);
        this.getAll().remove(civil);
        return civil;
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
