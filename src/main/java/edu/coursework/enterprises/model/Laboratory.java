package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Laboratory 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Laboratory {

    private String id;

    private String address;
    private List<Testing> tests;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Laboratory(String id, String address, List<Testing> tests) {
        this.id = id;
        this.address = address;
        this.tests = tests;
        this.created_at = LocalDateTime.now();
    }
}
