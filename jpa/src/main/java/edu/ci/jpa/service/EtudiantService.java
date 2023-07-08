package edu.ci.jpa.service;

import edu.ci.jpa.dto.AddEtudiantRequest;
import edu.ci.jpa.dto.UpdateEtudiantRequest;
import edu.ci.jpa.entity.Etudiant;
import edu.ci.jpa.repository.EtudiantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    public Etudiant createEtudiant(AddEtudiantRequest dto){
        Etudiant etudiant = Etudiant.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .matricule(dto.getMatricule())
                .build();
        return etudiantRepository.save(etudiant);
    }

    public Etudiant getOne(Long id){
        return etudiantRepository.findById(id)
                .orElseThrow(()
                -> new IllegalArgumentException("id invalide"));
    }
    public List<Etudiant> getAllEtudiant(){
        List<Etudiant> listEtudiant = etudiantRepository.findAll();
        return listEtudiant;
    }
    @Transactional
    public Etudiant updateEtudiant(UpdateEtudiantRequest dto){
       Etudiant etudiant=  etudiantRepository.findById(dto.getId())
                .orElseThrow(()
                        -> new IllegalArgumentException("id invalide"));

       etudiant.setNom(dto.getNom());
       etudiant.setPrenom(dto.getPrenom());
       etudiant.setMatricule(dto.getMatricule());
       return etudiant;

    }
    public void deleteEtudiant(Long id){
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if(etudiant.isPresent()){
            etudiantRepository.deleteById(id);
        }else {
            new IllegalArgumentException("invalide id");
        }
    }
}
