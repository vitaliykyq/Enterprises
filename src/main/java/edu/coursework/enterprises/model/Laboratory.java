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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "laboratory")
public class Laboratory {
    @Id
    private String id;

    private String address;
    private List<Testing> testingList;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Laboratory(String id, String address, List<Testing> testingList) {
        this.id = id;
        this.address = address;
        this.testingList = testingList;
        this.created_at = new Date();
    }
}
