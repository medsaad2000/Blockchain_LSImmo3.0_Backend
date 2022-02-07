package ma.fstt.Repository;

import ma.fstt.entities.Annonce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.Optional;

@RepositoryRestResource
public interface AnnonceRepository extends MongoRepository<Annonce,String> {
    @Query("{'titre_anc': ?0}")
    Optional<Annonce> findByName(String titre_anc);


    Annonce findAnnonceById(BigInteger id);
    void deleteAnnonceById(BigInteger id);
}
