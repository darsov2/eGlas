package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    LocalDate dateOfBirth;
    String idNum;
    @ManyToOne
    Address address;
    @Transient
    Integer yearsAge;
    @OneToOne(mappedBy = "citizen")
    Documents document;

    public String type()
    {
        return "citizen";
    }
}
