package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class VotingCode {
    @Id
    String code;
    @OneToOne
    Vote vote;

    public VotingCode(Vote vote) {
        this.code = UUID.randomUUID().toString();
        this.vote = vote;
    }
}
