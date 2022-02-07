package ma.fstt.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document
@Data  @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties
public class Categorie {
    @Id
    private String id;
    private String nom_cat;
    @DBRef
    private List<Annonce> annonces = new ArrayList<>();



    @Override
    public String toString() {
        return "Categorie{" +
                "id='" + id + '\'' +
                ", nom_cat='" + nom_cat + '\'' +
                '}';
    }

}


