package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "prigovori")
public class Objection {
    @Id
    @GeneratedValue
    @Column(name = "pr_id")
    Long id;
    @ManyToOne
    @JoinColumn(name = "p_id")
    Party party;
    @ManyToOne
    @JoinColumn(name = "ri_id")
    ElectionRealization electionRealization;
    @ManyToOne
    @JoinColumn(name = "im_id")
    PollingStation pollingStation;
    @Column(length = 10000, name = "pr_opis")
    String description;
}
