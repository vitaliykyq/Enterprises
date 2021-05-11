package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Transport 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transport {

    private String id;

    private int cargo;
    private String equipped;
    private boolean isGuard;
    private boolean isHatch;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Transport(String id, int cargo, String equipped, boolean isGuard, boolean isHatch) {
        this.id = id;
        this.cargo = cargo;
        this.equipped = equipped;
        this.isGuard = isGuard;
        this.isHatch = isHatch;
        this.created_at = LocalDateTime.now();
    }
}
