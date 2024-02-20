package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String documentNumber;
    LocalDate issueDate;
    LocalDate expiryDate;
    String issuer;
    @OneToOne
    Citizen citizen;
}
