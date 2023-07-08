package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddEnseignatRequest;
import edu.ci.jpa.dto.UpdateEnseignant;
import edu.ci.jpa.entity.Enseignant;
import edu.ci.jpa.service.EnseignantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }
    @PostMapping("/ens")
    public Enseignant addEnseigant(@RequestBody AddEnseignatRequest dto){
        return enseignantService.addEnseignant(dto);
    }
    @GetMapping("/ens/getOne/{id}")
    public Enseignant getOne(@PathVariable Long id){
        Optional<Enseignant> enseignantOptional =  enseignantService.getOne(id);
        if(enseignantOptional.isPresent()){
           return enseignantOptional.get();
        } else {
            return null;
        }

    }
    @GetMapping("/ens/getAll")
    public List<Enseignant> getAlls(){
        return enseignantService.getAll();
    }
    @PutMapping("/ens/update")
    public Enseignant updateEnseignant(@RequestBody UpdateEnseignant dto){
        return enseignantService.updateEnseignant(dto);
    }
    @DeleteMapping("/ens/delete/{id}")
    public void deleteEnseignant(@PathVariable Long id){
        enseignantService.supprimer(id);
    }
}
