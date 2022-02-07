package ma.fstt.service;

import ma.fstt.entity.Annonce;
import ma.fstt.entity.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="ANNONCE-SERVICE")
public interface AnnonceService {
    @PostMapping("/annonces/add")
    public Annonce addAnnonceC(@RequestBody Annonce annonce) ;
    @GetMapping("/categories/find/{id}")
    public Categorie getCategorieById (@PathVariable String id) ;

}
