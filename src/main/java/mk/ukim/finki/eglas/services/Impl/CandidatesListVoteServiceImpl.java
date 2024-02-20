package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.CandidatesListVote;
import mk.ukim.finki.eglas.repository.CandidatesListVoteRepository;
import mk.ukim.finki.eglas.services.CandidatesListService;
import mk.ukim.finki.eglas.services.CandidatesListVoteService;
import mk.ukim.finki.eglas.services.VoteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatesListVoteServiceImpl implements  CandidatesListVoteService{

    private final CandidatesListVoteRepository repository;
    private final VoteService voteService;
    private final CandidatesListService candidatesListService;

    public CandidatesListVoteServiceImpl(CandidatesListVoteRepository repository,
                                         VoteService voteService,
                                         CandidatesListService candidatesListService){
        this.repository = repository;
        this.voteService = voteService;
        this.candidatesListService = candidatesListService;
    }

    public CandidatesListVote findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("no candidate list vote found"));
    }

    public List<CandidatesListVote> findAll(){
        return repository.findAll();
    }

    public CandidatesListVote update(Long id, Long CandidateListId){
        CandidatesListVote clv = (CandidatesListVote) voteService.findById(id);
        clv.setCandidatesList(candidatesListService.findById(id));
        return repository.save(clv);
    }

    public void delete(Long id){
        repository.delete(findById(id));
    };
}
