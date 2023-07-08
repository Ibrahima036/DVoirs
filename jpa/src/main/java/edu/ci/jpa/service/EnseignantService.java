package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddEnseignatRequest;
import edu.ci.jpa.dto.UpdateEnseignant;
import edu.ci.jpa.entity.Cours;
import edu.ci.jpa.entity.Enseignant;
import edu.ci.jpa.repository.EnseignantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {
    private final EnseignantRepository enseignantRepository;

    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    public Enseignant addEnseignant(AddEnseignatRequest dto) {
        Enseignant enseignant = Enseignant.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .tel(dto.getTel())
                .adresse(dto.getAdresse())
                .build();
        return enseignantRepository.save(enseignant);
    }
    public List<Enseignant> getAll(){
        List<Enseignant> listeEnseignant = enseignantRepository.findAll();
        return listeEnseignant;
    }
    public Optional<Enseignant>  getOne(Long id){
        return enseignantRepository.findById(id);
    }
    @Transactional
    public Enseignant updateEnseignant(UpdateEnseignant dto){
        Enseignant enseignant = enseignantRepository.findById(dto.getId())
                .orElseThrow(()
                        -> new IllegalArgumentException("invalide id"));

        enseignant.setAdresse(dto.getAdresse());
        enseignant.setTel(dto.getTel());
        enseignant.setPrenom(dto.getPrenom());
        enseignant.setNom(dto.getNom());

        return enseignant;
    }
    public void supprimer(Long id){
        enseignantRepository.deleteById(id);
    }

}

