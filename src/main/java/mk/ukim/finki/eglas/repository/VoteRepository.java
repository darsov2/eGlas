package mk.ukim.finki.eglas.repository;

import mk.ukim.finki.eglas.model.CandidatesElectionRealization;
import mk.ukim.finki.eglas.model.ElectionRealization;
import mk.ukim.finki.eglas.model.Vote;
import mk.ukim.finki.eglas.records.TotalCandidacyResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query(value = "SELECT (SELECT COUNT(v) FROM Vote v WHERE v.electionRealization = :ri) * 100.0 / (SELECT COUNT(c) FROM Citizen c WHERE c.dateOfBirth <= :dateThreshold) FROM ElectionRealization ri WHERE ri = :ri")
    public Double turnOutByRealization(@Param("ri") ElectionRealization electionRealization, @Param("dateThreshold") LocalDate dateThreshold);

    @Query("SELECT NEW mk.ukim.finki.eglas.records.TotalCandidacyResults(kan, COUNT(distinct cv), null) " +
            "FROM Candidate k " +
            "LEFT JOIN Candidacy kan ON kan.candidate = k AND kan.candidatesElectionRealization = :realization " +
            "LEFT JOIN CandidacyVote cv ON cv.candidacy = kan " +
            "WHERE kan is not null " +
            "GROUP BY kan")
    List<TotalCandidacyResults> countVotesByCitizenAndRealization(@Param("realization") CandidatesElectionRealization realization);
}