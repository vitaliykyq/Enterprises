package edu.coursework.enterprises.service.missile.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Missile;
import edu.coursework.enterprises.repository.MissileRepository;
import edu.coursework.enterprises.service.missile.interfaces.IMissileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MissileServiceImpl implements IMissileService {

    @Autowired
    MissileRepository repository;

    @Override
    public Missile getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Missile create(Missile missile) {
        missile.setCreatedAt(new Date());
        return repository.save(missile);
    }

    @Override
    public Missile update(Missile missile) {
        missile.setModifiedAt(new Date());
        missile.setCreatedAt(repository.findById(missile.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(missile);
        return missile;
    }

    @Override
    public Missile delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Missile> getAll() {

        return repository.findAll();
    }
}
