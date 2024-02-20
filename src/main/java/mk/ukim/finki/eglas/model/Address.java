package mk.ukim.finki.eglas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String street;
    Integer houseNumber;
    Integer entranceNumber;
    Integer apartmentNumber;
    @ManyToOne
    Municipality municipality;
    @ManyToOne
    PollingStation pollingStation;
}
