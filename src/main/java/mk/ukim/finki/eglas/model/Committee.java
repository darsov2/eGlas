package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    PollingStation pollingStation;
    @ManyToOne
    ElectionRealization electionRealization;
    @ManyToMany
    List<CommitteeMember> members;

    public Committee(){
        this.members = new ArrayList<>();
    }
}
