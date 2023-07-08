package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddCoursRequest;
import edu.ci.jpa.dto.AddMatiereRequest;
import edu.ci.jpa.dto.UpdateCousRequest;
import edu.ci.jpa.dto.UpdateMatiereRequest;
import edu.ci.jpa.entity.Cours;
import edu.ci.jpa.entity.Matiere;
import edu.ci.jpa.service.MatiereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatiereController {
    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }
    @PostMapping("/create")
    public void createCours(@RequestBody AddMatiereRequest dto){
        matiereService.Addcours(dto);
    }
    @GetMapping("/getall")
    public List<Matiere> getAllCours(){
        List<Matiere> matieres = matiereService.getAll();
        return matieres;
    }
    @GetMapping("/getone/{id}")
    public Optional<Matiere> findById(@PathVariable Long  id){
        Optional<Matiere> matiere = matiereService.findById(id);
        return matiere;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCours (@PathVariable Long id){
        matiereService.supprimerCours(id);
    }
    @PutMapping("/update")
    public Matiere updateCours(@RequestBody UpdateMatiereRequest dto){
        return matiereService.updateCours(dto);
    }
}
