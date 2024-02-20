package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Objection {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Party party;
    @ManyToOne
    ElectionRealization electionRealization;
    @ManyToOne
    PollingStation pollingStation;
    @Column(length = 10000)
    String description;
}
