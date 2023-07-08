package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddCoursRequest;
import edu.ci.jpa.dto.UpdateCousRequest;
import edu.ci.jpa.entity.Cours;
import edu.ci.jpa.entity.Enseignant;
import edu.ci.jpa.repository.CoursRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class CoursService {
    private CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public void Addcours(AddCoursRequest dto) {
        Cours cours = Cours.builder()
                .libelle(dto.getLibelle())
                .nbHeure(dto.getNbHeure())
                .build();
        coursRepository.save(cours);
    }

    public List<Cours> getAll() {
        return coursRepository.findAll();
    }

    public Optional<Cours> findById(Long id) {
        Optional<Cours> coursOp = coursRepository.findById(id);
        return coursOp;
    }

    public void supprimerCours(Long id) {
        Optional<Cours> coursOp = coursRepository.findById(id);
        if (coursOp.isPresent()) {
            coursRepository.deleteById(id);
        }
    }

    @Transactional
    public Cours updateCours(UpdateCousRequest dto) {
        Cours cours = coursRepository.findById(dto.getId())
                .orElseThrow(()
                        -> new IllegalArgumentException("invalide id"));

        cours.setLibelle(dto.getLibelle());
        cours.setNbHeure(dto.getNbHeure());
        return cours;
    }

}
