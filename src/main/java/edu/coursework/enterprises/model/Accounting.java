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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounting")
public class Accounting {
    @Id
    private String id;

    private Product product;
    private Laboratory laboratory;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Accounting(String id, Product product, Laboratory laboratory) {
        this.id = id;
        this.product = product;
        this.laboratory = laboratory;
        this.created_at = new Date();
    }
}
