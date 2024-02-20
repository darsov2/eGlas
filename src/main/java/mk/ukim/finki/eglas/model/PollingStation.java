package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PollingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    ElectoralUnit electoralUnit;
    @ManyToOne
    Address address;
}
