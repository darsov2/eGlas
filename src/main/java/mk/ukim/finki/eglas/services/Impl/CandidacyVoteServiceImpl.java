package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.CandidacyVote;
import mk.ukim.finki.eglas.repository.CandidacyVoteRepository;
import mk.ukim.finki.eglas.services.CandidacyService;
import mk.ukim.finki.eglas.services.CandidacyVoteService;
import mk.ukim.finki.eglas.services.VoteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidacyVoteServiceImpl implements CandidacyVoteService {

    private final CandidacyVoteRepository repository;
    private final VoteService voteService;
    private final CandidacyService candidacyService;

    public CandidacyVoteServiceImpl(CandidacyVoteRepository repository, VoteService voteService, CandidacyService candidacyService) {
        this.repository = repository;
        this.voteService = voteService;
        this.candidacyService = candidacyService;
    }

    public List<CandidacyVote> findAll(){
        return repository.findAll();
    }
    public CandidacyVote findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("no candidacy vote found"));
    }
    public CandidacyVote update(Long voteId, Long candidacyId){
        CandidacyVote cand = (CandidacyVote) voteService.findById(voteId);
        cand.setCandidacy(candidacyService.findById(candidacyId));
        return repository.save(cand);
    }

    @Override
    public void voteForCandidate(Long voteId, Long id){
        repository.voteForCandidate(voteId, id);
    }

    public CandidacyVote delete(Long id){
        CandidacyVote cv = findById(id);
        repository.delete(cv);
        return cv;
    }
}
