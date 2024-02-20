package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime voteTimestamp;
    @ManyToOne
    Citizen citizen;
    @ManyToOne
    ElectionRealization electionRealization;
}
