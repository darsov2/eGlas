package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Coalition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String motto;
    @ManyToOne
    ElectionRealization electionRealization;
    @ManyToMany
    List<Party> parties;

    public Coalition(){
        this.parties = new ArrayList<>();
    }
}
