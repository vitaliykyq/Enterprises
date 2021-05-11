package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Produce 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Produce {

    private String id;

    private Product product;
    private int amount;
    private LocalDate date;
    private String status;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Produce(String id, Product product, int amount, LocalDate date, String status) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.created_at = LocalDateTime.now();
    }
}
