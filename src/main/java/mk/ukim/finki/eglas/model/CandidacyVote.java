package mk.ukim.finki.eglas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
//@PrimaryKeyJoinColumn
public class CandidacyVote extends Vote{
    @ManyToOne
    private Candidacy candidacy;
}
