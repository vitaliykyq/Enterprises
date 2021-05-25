package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Plane 
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
@Document(collection = "plane")
public class Plane {
    @Id
    private String id;

    private String name;
    private String model;
    private Object type;
    private int issue;
    private int aircrew;
    private int payload;
    private double height;
    private double length;
    private double wingspan;
    private double ceiling;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
