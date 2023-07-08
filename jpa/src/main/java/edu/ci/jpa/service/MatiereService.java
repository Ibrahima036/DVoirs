package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddMatiereRequest;
import edu.ci.jpa.dto.UpdateMatiereRequest;
import edu.ci.jpa.entity.Matiere;
import edu.ci.jpa.repository.MatiereRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    public void Addcours(AddMatiereRequest dto) {
        Matiere matiere = Matiere.builder()
                .libelle(dto.getLibelle())
                .nbHeure(dto.getNbHeure())
                .build();
        matiereRepository.save(matiere);
    }

    public List<Matiere> getAll() {
        return matiereRepository.findAll();
    }

    public Optional<Matiere> findById(Long id) {
        Optional<Matiere> matiere = matiereRepository.findById(id);
        return matiere;
    }

    public void supprimerCours(Long id) {
        Optional<Matiere> matiere = matiereRepository.findById(id);
        if (matiere.isPresent()) {
            matiereRepository.deleteById(id);
        }
    }

    @Transactional
    public Matiere updateCours(UpdateMatiereRequest dto) {
        Matiere matiere = matiereRepository.findById(dto.getId())
                .orElseThrow(()
                        -> new IllegalArgumentException("invalide id"));

        matiere.setLibelle(dto.getLibelle());
        matiere.setNbHeure(dto.getNbHeure());
        return matiere;
    }
}
