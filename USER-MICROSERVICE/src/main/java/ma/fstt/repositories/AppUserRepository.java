package ma.fstt.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import ma.fstt.entities.AppUser;

@RepositoryRestResource
public interface AppUserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(@Param("username") String username);

    AppUser findByEmail(String email);
}
