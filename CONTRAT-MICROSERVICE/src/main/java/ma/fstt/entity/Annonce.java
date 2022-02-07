package ma.fstt.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id
    private BigInteger id;
    private BigInteger idImm ;
    private String titre_anc;
    private Date date_anc;
    private String url_img;
    private String description;
    private double prix_anc;

    private Categorie categories;
}
