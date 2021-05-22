package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Product 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private String id;

    private Object type;
    private List<String> operation;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Product(String id, Object type, List<String> operation) {
        this.id = id;
        this.type = type;
        this.operation = operation;
        this.created_at = new Date();
    }
}
