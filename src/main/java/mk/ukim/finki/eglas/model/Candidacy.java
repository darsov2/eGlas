package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @ManyToOne
    Candidate candidate;
    @ManyToOne
    Party party;
    @ManyToOne
    CandidatesElectionRealization candidatesElectionRealization;
    @ManyToOne
    Municipality municipality;
}
