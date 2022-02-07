package ma.fstt.services;

import org.springframework.stereotype.Service;

import ma.fstt.entities.AppRole;
import ma.fstt.entities.AppUser;


public interface AccountService {

    //inscrire un joueur
    public AppUser saveUser(String username, String email, String adress, String password, String confirmedPassword);
    //Ajouter des roles
    public AppRole save(AppRole role);

    public AppUser loadUserByUsername(String username);

    public void addRoleToUser(String username, String roleName);

}
