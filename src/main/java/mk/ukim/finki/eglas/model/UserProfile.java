package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "korisnicki_profil")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kp_id")
    Long id;
    @Column(name = "kp_korisnicko_ime")
    String userName;
    @Column(name = "kp_lozinka")
    String password;
    @Column(name = "kp_uloga")
    String role;
    @OneToOne
    @JoinColumn(name = "g_id")
    Citizen citizen;
}
