package edu.ci.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddEnseignatRequest {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private AddCoursRequest cours;
}
