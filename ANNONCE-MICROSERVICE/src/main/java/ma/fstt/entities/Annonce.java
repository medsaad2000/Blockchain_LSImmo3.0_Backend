package ma.fstt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document
@Data
 @NoArgsConstructor @AllArgsConstructor
@ToString
@JsonIgnoreProperties
public class Annonce {

    @Id
    private BigInteger id;
    private BigInteger idImm ;
    private String titre_anc;
    private Date date_anc;
    private String url_img;
    private String description;
    private double prix_anc;
    @DBRef
    @JsonIgnoreProperties("annonces")
    private Categorie categories;

}
