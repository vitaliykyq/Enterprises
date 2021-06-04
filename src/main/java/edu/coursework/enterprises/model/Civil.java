package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Civil 
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
@Document(collection = "civil")
public class Civil {
    @Id
    private String id;

    private Boolean isBusiness;
    private int seats;
    private Boolean isBaggage;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
