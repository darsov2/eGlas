package mk.ukim.finki.eglas.repository;

import mk.ukim.finki.eglas.model.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeRepository extends JpaRepository<Committee, Long> {
}
