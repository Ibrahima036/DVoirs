package edu.ci.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEtudiantRequest {
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
}
