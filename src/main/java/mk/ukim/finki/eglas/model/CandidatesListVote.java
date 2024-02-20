package mk.ukim.finki.eglas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
//@PrimaryKeyJoinColumn
public class CandidatesListVote extends Vote{
    @ManyToOne
    CandidatesList candidatesList;
}
