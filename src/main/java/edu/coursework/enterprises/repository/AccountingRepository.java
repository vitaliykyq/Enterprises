package edu.coursework.enterprises.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    AccountingRepository 
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Accounting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends MongoRepository<Accounting, String> {
}
