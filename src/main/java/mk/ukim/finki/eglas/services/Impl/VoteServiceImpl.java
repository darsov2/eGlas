package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.CandidatesElectionRealization;
import mk.ukim.finki.eglas.model.Citizen;
import mk.ukim.finki.eglas.model.ElectionRealization;
import mk.ukim.finki.eglas.model.Vote;
import mk.ukim.finki.eglas.records.TotalCandidacyResults;
import mk.ukim.finki.eglas.repository.VoteRepository;
import mk.ukim.finki.eglas.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final ElectionRealizationService electionRealizationService;
    private final CitizenService citizenService;
    private final VoteRepository voteRepository;
    @Autowired
    private CandidatesElectionRealizationService candidatesElectionRealizationService;

    public VoteServiceImpl(ElectionRealizationService electionRealizationService, CitizenService citizenService, VoteRepository voteRepository) {
        this.electionRealizationService = electionRealizationService;
        this.citizenService = citizenService;
        this.voteRepository = voteRepository;
    }

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    @Override
    public Vote findById(Long id) {
        return voteRepository.findById(id).orElseThrow(() -> new RuntimeException("Vote not found"));
    }

    @Override
    public Vote update(Long id, LocalDateTime voteTimestamp, Long citizenId, Long electionRealizationId) {
        Vote vote = new Vote();
        Citizen citizen = citizenService.findById(citizenId);
        ElectionRealization electionRealization = electionRealizationService.findById(electionRealizationId);
        if(id != null)
        {
            vote = findById(id);
        }
        vote.setVoteTimestamp(voteTimestamp);
        vote.setCitizen(citizen);
        vote.setElectionRealization(electionRealization);
        return voteRepository.save(vote);
    }

    @Override
    public Vote delete(Long id) {
        Vote vote = findById(id);
        voteRepository.delete(vote);
        return vote;
    }

    @Override
    public Double turnOutByElectionRealization(Long id)
    {
        ElectionRealization electionRealization = electionRealizationService.findById(id);
        return voteRepository.turnOutByRealization(electionRealization, LocalDate.now().minusYears(18));
    }

    @Override
    public List<TotalCandidacyResults> resultsByCandidateElectionsRealization(Long realizationId)
    {
        CandidatesElectionRealization candidatesElectionRealization = candidatesElectionRealizationService.findById(realizationId);
        List<TotalCandidacyResults> votes = voteRepository.countVotesByCitizenAndRealization(candidatesElectionRealization);
        Long totalVotes = votes.stream().mapToLong(TotalCandidacyResults::voteCount).sum();
        return votes.stream()
                .map(x -> new TotalCandidacyResults(x.candidacy(), x.voteCount(), x.voteCount() * 100.0 / totalVotes))
                .sorted(Comparator.comparing(TotalCandidacyResults::voteCount).reversed())
                .toList();
    }
}
