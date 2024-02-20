package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.VotingCode;
import mk.ukim.finki.eglas.repository.VotingCodeRepository;
import mk.ukim.finki.eglas.services.VoteService;
import mk.ukim.finki.eglas.services.VotingCodeService;

import java.util.List;

public class VotingCodeServiceImpl implements VotingCodeService {

    private final VotingCodeRepository votingCodeRepository;
    private final VoteService voteService;

    public VotingCodeServiceImpl(VotingCodeRepository votingCodeRepository, VoteService voteService) {
        this.votingCodeRepository = votingCodeRepository;
        this.voteService = voteService;
    }


    @Override
    public List<VotingCode> findAll() {
        return votingCodeRepository.findAll();
    }

    @Override
    public VotingCode findByCode(String code) {
        return votingCodeRepository.findByCode(code);
    }

    @Override
    public VotingCode update(Long id, String name, Long addressId) {
        return null;
    }

    @Override
    public VotingCode delete(Long id) {
        return null;
    }
}
