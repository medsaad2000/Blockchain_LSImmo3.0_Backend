package ma.fstt.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.fstt.entities.AppRole;
import ma.fstt.entities.AppUser;
import ma.fstt.repositories.AppRoleRepository;
import ma.fstt.repositories.AppUserRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String email, String adress, String password, String confirmedPassword) {
        System.out.println("----------- here ----------------");
        //------- //verifier si l'utlisateur existe deja --------
        AppUser user = appUserRepository.findByUsername(username);
        if (user != null) throw new RuntimeException("User already exists");

        if (!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");

        //------------  Else cree un utilisateur----------
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setEmail(email);
        appUser.setAdress(adress);
//		appUser.setTypeUser(typeUser);
//		appUser.setFunction(function);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));  //enregistrer dans la BD d'une maniere cryptée

        //--------- Add role to user -----------------
        AppRole userRole1 = appRoleRepository.findByRoleName("ADMIN");
//		AppRole userRole2 = appRoleRepository.findByRoleName("ADMIN");

        appUser.setRoles(new HashSet<>(Arrays.asList(userRole1)));
        System.out.println(appUser);
        appUserRepository.save(appUser);
//		addRoleToUser(username, "USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);

        System.out.println("------------" + appRole);
        appUser.getRoles().add(appRole);
        System.out.println(appUser.getRoles());
    }

//	@Override
//	public Employee saveEmployee(String cv) {
//		//------------ Create User ---
//		Employee emp =  new Employee();
//		emp.setCv(cv);
//		employeeRepository.save(emp);
//		return emp;
//	}
//
//	@Override
//	public Enterprise saveEnterprise(int score, String function) {
//		//------------ Create User ---
//		Enterprise ent =  new Enterprise();
//		ent.setFunction(function);
//		ent.setScore(score);
//		enterpriseRepository.save(ent);
//		return ent;
//	}

}
