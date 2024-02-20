package mk.ukim.finki.eglas.repository;

import mk.ukim.finki.eglas.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByIdNum(String idNum);
}
