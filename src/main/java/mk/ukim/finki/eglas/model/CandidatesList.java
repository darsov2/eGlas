package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.eglas.repository.CandidatesListRepository;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CandidatesList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @ManyToMany
    List<Candidate> candidates;
    @ManyToOne
    CandidatesListElectionRealization candidatesListElectionRealization;

    public CandidatesList(){
        this.candidates = new ArrayList<>();
    }

}
