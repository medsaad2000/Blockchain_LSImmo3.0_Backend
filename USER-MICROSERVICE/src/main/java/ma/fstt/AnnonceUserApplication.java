package ma.fstt;

import ma.fstt.entities.AppRole;
import ma.fstt.repositories.AppRoleRepository;
import ma.fstt.repositories.AppUserRepository;
import ma.fstt.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AnnonceUserApplication implements CommandLineRunner {

    @Autowired
    AccountService accountService;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AppRoleRepository appRoleRepository;
//	@Autowired CustomUserDetailsService customUserDetailsService;

    public static void main(String[] args) {
        SpringApplication.run(AnnonceUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        appUserRepository.deleteAll();
        appRoleRepository.deleteAll();
        accountService.save(new AppRole("USER"));
        accountService.save(new AppRole("ADMIN"));
        accountService.save(new AppRole("TEST"));

        accountService.saveUser("user1", "user1@email", "Tanger", "123456789", "123456789");
        accountService.saveUser("yazid", "yazid@email", "casa", "123", "123");
        accountService.saveUser("saad", "saad@email", "Khouribga", "123", "123");
        accountService.saveUser("admin", "admin@email.com", "Tanger", "123", "123");


    }

    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
}
