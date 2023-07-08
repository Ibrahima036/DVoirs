package edu.ci.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddCoursRequest {
    private String libelle;
    private Integer nbHeure;
    private  Long id;
}
