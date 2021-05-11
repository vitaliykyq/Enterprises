package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Accounting 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Accounting {

    private String id;

    private Product product;
    private Laboratory laboratory;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Accounting(String id, Product product, Laboratory laboratory) {
        this.id = id;
        this.product = product;
        this.laboratory = laboratory;
        this.created_at = LocalDateTime.now();
    }
}
