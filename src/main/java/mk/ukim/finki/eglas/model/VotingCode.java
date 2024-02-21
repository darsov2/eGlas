package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "kodovi")
public class VotingCode {
    @Id
    @Column(name = "kod_kod")
    String code;
    @JoinColumn(name = "ug_id")
    @OneToOne
    Vote vote;
    @Column(name = "kod_vazi_do")
    LocalDateTime expiryTime;
    public VotingCode(Vote vote) {
        this.code = UUID.randomUUID().toString();
        this.vote = vote;
    }
}
