package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class ElectionRealization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate date;
    String name;
    @ManyToOne
    Election election;
}
