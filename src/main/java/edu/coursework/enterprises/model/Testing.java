package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Testing 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Testing {

    private String id;

    private List<Product> products;
    private LocalDate date;
    private List<Engineer> testers;
    private List<Equipment> equipment;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Testing(String id, List<Product> products, LocalDate date,
                   List<Engineer> testers, List<Equipment> equipment) {
        this.id = id;
        this.products = products;
        this.date = date;
        this.testers = testers;
        this.equipment = equipment;
        this.created_at = LocalDateTime.now();
    }
}
