package mk.ukim.finki.eglas.services;

import mk.ukim.finki.eglas.model.CandidacyVote;

import java.util.List;

public interface CandidacyVoteService {
    List<CandidacyVote> findAll();
    CandidacyVote findById(Long id);
    CandidacyVote update(Long voteId, Long candidacyId);
    CandidacyVote delete(Long id);
    void voteForCandidate(Long voteId, Long id);
}
