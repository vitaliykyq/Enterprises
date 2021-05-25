package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Plot 
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
@Document(collection = "plot")
public class Plot {
    @Id
    private String id;

    private List<Produce> produceList;
    private Engineer head;
    private List<Brigade> brigadeList;
    private List<Engineer> engineerList;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
