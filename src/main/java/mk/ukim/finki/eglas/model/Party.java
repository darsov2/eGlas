package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne
    Address address;
}
