package mk.ukim.finki.eglas.services;

import jakarta.persistence.ManyToOne;
import mk.ukim.finki.eglas.model.Citizen;
import mk.ukim.finki.eglas.model.ElectionRealization;
import mk.ukim.finki.eglas.model.Vote;
import mk.ukim.finki.eglas.records.TotalCandidacyResults;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteService {
    List<Vote> findAll();
    Vote findById(Long id);
    Vote update(Long id, LocalDateTime voteTimestamp, Long citizenId, Long electionRealizationId);
    Vote delete(Long id);
    Double turnOutByElectionRealization(Long id);

    List<TotalCandidacyResults> resultsByCandidateElectionsRealization(Long realizationId);
}
