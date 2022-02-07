package ma.fstt.service;

import ma.fstt.Repository.CategorieRepository;
import ma.fstt.entities.Annonce;
import ma.fstt.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;
    public List<Categorie> findAllCategories(){
        return categorieRepository.findAll();
    }
    public Categorie findCategorieById(String id) {
        return categorieRepository.findById(id).get();
    }


}
