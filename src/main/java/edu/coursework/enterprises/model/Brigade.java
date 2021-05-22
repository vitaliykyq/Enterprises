package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Brigade 
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
@Document(collection = "brigade")
public class Brigade {
    @Id
    private String id;

    private Worker brigadier;
    private List<Worker> workerList;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Brigade(String id, Worker brigadier, List<Worker> workerList) {
        this.id = id;
        this.brigadier = brigadier;
        this.workerList = workerList;
        this.created_at = new Date();
    }
}
