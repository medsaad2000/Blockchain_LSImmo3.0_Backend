package ma.fstt.controller;


import ma.fstt.Repository.AnnonceRepository;
import ma.fstt.Repository.CategorieRepository;
import ma.fstt.entities.Annonce;
import ma.fstt.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/annonces")

public class AnnonceController {
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    AnnonceService annonceService;


    @PostMapping("/add")
    public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce annonce) {
        Annonce newAnnonce = annonceService.addAnnonce(annonce);
        return new ResponseEntity<>(newAnnonce, HttpStatus.CREATED);
    }
    @PostMapping("/addAC")
    public Annonce addAnnonceC(Annonce annonce) {
        Annonce newAnnonce = annonceService.addAnnonce(annonce);
        return newAnnonce;
    }


    @GetMapping("/AllAnnonce")
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        List<Annonce> annonces = annonceService.findAllAnnonce();
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Annonce> getAnnonceById (@PathVariable("id") BigInteger id) {
        Annonce annonce = annonceService.findAnnonceById(id);
        System.out.println(annonce);
        return new ResponseEntity<>(annonce, HttpStatus.OK);
    }
   @PutMapping  ("/update")
    public ResponseEntity<Annonce> updateAnnonce(@RequestBody Annonce annonce){
        Annonce annonce1 = annonceService.updateAnnonce(annonce);
        System.out.println(annonce1);
        System.out.println("---------------------------------");
        return new ResponseEntity<>(annonce1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnonce(@PathVariable("id") BigInteger id) {
        annonceService.deleteAnnonce(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




/*
    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie cat) {
        System.out.println("Categorie:"+cat.getNom_cat());
        Annonce anc = annonceRepository.findById(cat.getId()).get();
        cat.setAnnonces((Collection<Annonce>) anc);


        return categorieRepository.save(cat);
    }

    @PostMapping("/addAnnonce")
    public void  addAnnonce(@RequestBody Annonce an){
        annonceRepository.save(an);
    }

    @GetMapping("/allAnnouncements")
    public Collection<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }*/




