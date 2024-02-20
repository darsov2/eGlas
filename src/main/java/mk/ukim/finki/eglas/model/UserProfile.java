package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;
    String role;
    @OneToOne
    Citizen citizen;
}
