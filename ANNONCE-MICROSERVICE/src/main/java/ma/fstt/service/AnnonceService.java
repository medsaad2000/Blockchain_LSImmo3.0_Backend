package ma.fstt.service;

import ma.fstt.Repository.AnnonceRepository;
import ma.fstt.entities.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service


public class AnnonceService {
    private AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce addAnnonce(Annonce annonce) {

        return annonceRepository.save(annonce);
    }

    public List<Annonce> findAllAnnonce() {
        return annonceRepository.findAll();
    }

    public Annonce updateAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }


    public Annonce findAnnonceById(BigInteger id) {
        return annonceRepository.findAnnonceById(id);
    }
    public void deleteAnnonce(BigInteger id){
        annonceRepository.deleteAnnonceById(id);
    }

}



