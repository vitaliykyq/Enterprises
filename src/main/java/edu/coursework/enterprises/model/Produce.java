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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produce")
public class Produce {
    @Id
    private String id;

    private Product product;
    private int amount;
    private String date;
    private String status;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Produce(String id, Product product, int amount, String date, String status) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.created_at = new Date();
    }
}
