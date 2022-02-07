package ma.fstt;

import ma.fstt.Repository.AnnonceRepository;
import ma.fstt.Repository.CategorieRepository;
import ma.fstt.entities.Annonce;
import ma.fstt.entities.Categorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }


    Categorie c2,c1;
    @Bean


//------------------------------Tester Categorie et annonce -------------------------//
    CommandLineRunner start(CategorieRepository categorieRepository, AnnonceRepository annonceRepository){

        // ------------------------------Tester Categorie et annonce -------------------------//
        return args -> {
            categorieRepository.deleteAll();
            Stream.of("C1 Villa", "C2 Studio","C3 Maison", "C4 Garage").forEach(c ->{
                categorieRepository.save(new Categorie(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
            });
            categorieRepository.findAll().forEach(System.out::println);

            annonceRepository.deleteAll();
            Categorie c1= categorieRepository.findById("C1").get();
            Stream.of("P1").forEach(name ->{
                Annonce p2= annonceRepository.save(new Annonce(null,null,"villa de saad ",new Date(),"https://i.ytimg.com/vi/Fw1IBJxcgc4/maxresdefault.jpg","villa de luxe sur bord de la mer",20,c1));

                c1.getAnnonces().add(p2);
                categorieRepository.save(c1);
            });

            Categorie c2= categorieRepository.findById("C2").get();
            Stream.of("P5").forEach(name ->{
                Annonce p= annonceRepository.save(new Annonce(null,null,"studio",new Date(),"https://urlz.fr/hjyi","studio pres de la zone industrielle",24,c2));

                c2.getAnnonces().add(p);
                categorieRepository.save(c2);
            });
            categorieRepository.save(c2);
            Categorie c3= categorieRepository.findById("C3").get();
            Stream.of("P8").forEach(name ->{
                Annonce p= annonceRepository.save(new Annonce(null,null,"maison de luxe ",new Date(),"https://urlz.fr/hk0V"," bord de la mer",10,c3));

                c3.getAnnonces().add(p);

                categorieRepository.save(c3);
            });
            Categorie c4= categorieRepository.findById("C4").get();
            Stream.of("P10").forEach(name ->{

                Annonce p2= annonceRepository.save(new Annonce(null,null,"garage de yazid ",new Date(),"https://www.midlandgaragedoor.com/wp-content/uploads/2018/10/WEB.jpg","villa de luxe sur bord de la mer",14,c4));

                c4.getAnnonces().add(p2);
                categorieRepository.save(c4);
            });

            annonceRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}