package mk.ukim.finki.eglas.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.eglas.model.CandidatesListElectionRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatesListElectionRealizationRepository extends JpaRepository<CandidatesListElectionRealization, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into candidates_list_election_realization (id) values (:id)", nativeQuery = true)
    void insertCandidateListElections(@Param("id") Long id);
}
