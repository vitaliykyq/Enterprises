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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "testing")
public class Testing {
    @Id
    private String id;

    private List<Product> productList;
    private String date;
    private List<Engineer> testerList;
    private List<Equipment> equipmentList;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Testing(String id, List<Product> productList, String date,
                   List<Engineer> testerList, List<Equipment> equipmentList) {
        this.id = id;
        this.productList = productList;
        this.date = date;
        this.testerList = testerList;
        this.equipmentList = equipmentList;
        this.created_at = new Date();
    }
}
