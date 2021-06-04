package edu.coursework.enterprises.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TransportRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Transport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends MongoRepository<Transport, String> {
}
