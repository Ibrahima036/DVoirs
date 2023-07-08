package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddEtudiantRequest;
import edu.ci.jpa.entity.Etudiant;
import edu.ci.jpa.service.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }
    @PostMapping("/add")
    public Etudiant createEtudiant(@RequestBody AddEtudiantRequest dto){
        return etudiantService.createEtudiant(dto);
    }
    @GetMapping("/etu/getone/{id}")
    public Etudiant getOne(@PathVariable Long id){
        return etudiantService.getOne(id);
    }
    @GetMapping("/etu/getAll")
    public List<Etudiant> getAll(){
        return etudiantService.getAllEtudiant();
    }

}
