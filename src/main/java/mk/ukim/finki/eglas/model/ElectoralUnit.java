package mk.ukim.finki.eglas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ElectoralUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer numDeputies;
    String name;

    public ElectoralUnit(String name, Integer numDeputies) {
        this.numDeputies = numDeputies;
        this.name = name;
    }
}
