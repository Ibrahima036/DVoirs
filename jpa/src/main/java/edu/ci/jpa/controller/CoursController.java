package edu.ci.jpa.controller;

import edu.ci.jpa.dto.AddCoursRequest;
import edu.ci.jpa.dto.UpdateCousRequest;
import edu.ci.jpa.entity.Cours;
import edu.ci.jpa.service.CoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cours")
public class CoursController {
    private final CoursService coursService;
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }
    @PostMapping("/create")
    public void createCours(@RequestBody AddCoursRequest dto){
        coursService.Addcours(dto);
    }
    @GetMapping("/getall")
    public List<Cours> getAllCours(){
        List<Cours> cours = coursService.getAll();
        return cours;
    }
    @GetMapping("/getone/{id}")
    public Optional<Cours> findById(@PathVariable Long  id){
        Optional<Cours> cours = coursService.findById(id);
        return cours;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCours (@PathVariable Long id){
        coursService.supprimerCours(id);
    }
    @PutMapping("/update")
    public Cours updateCours(@RequestBody UpdateCousRequest dto){
        return coursService.updateCours(dto);
    }
}
