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

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Plot {

    private String id;

    private List<Produce> produces;
    private Engineer head;
    private List<Brigade> brigades;
    private List<Engineer> engineers;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Plot(String id, List<Produce> produces, Engineer head,
                List<Brigade> brigades, List<Engineer> engineers) {
        this.id = id;
        this.produces = produces;
        this.head = head;
        this.brigades = brigades;
        this.engineers = engineers;
        this.created_at = LocalDateTime.now();
    }
}
