package ma.fstt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceKey {
    private Immobilier immobilier ;
    private String privateKey ;
    private String url ; 

}
