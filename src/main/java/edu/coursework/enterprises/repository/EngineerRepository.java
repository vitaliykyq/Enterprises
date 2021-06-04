package edu.coursework.enterprises.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    EngineerRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Engineer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineerRepository extends MongoRepository<Engineer, String> {
}
