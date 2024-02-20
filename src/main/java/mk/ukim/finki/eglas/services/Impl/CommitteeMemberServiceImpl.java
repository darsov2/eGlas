package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.CommitteeMember;
import mk.ukim.finki.eglas.repository.CommitteeMemberRepository;
import mk.ukim.finki.eglas.services.CitizenService;
import mk.ukim.finki.eglas.services.CommitteeMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommitteeMemberServiceImpl implements CommitteeMemberService {


    private final CommitteeMemberRepository committeeMemberRepository;
    private final CitizenService citizenService;

    public CommitteeMemberServiceImpl(CommitteeMemberRepository committeeMemberRepository, CitizenService citizenService) {
        this.committeeMemberRepository = committeeMemberRepository;
        this.citizenService = citizenService;
    }


    @Override
    public CommitteeMember findById(Long id) {
        return committeeMemberRepository.findById(id).orElseThrow(() -> new RuntimeException("No committee member found"));
    }

    @Override
    public List<CommitteeMember> findAll() {
        return committeeMemberRepository.findAll();
    }

    @Override
    public CommitteeMember update(Long id) {
        committeeMemberRepository.insertCommitteeMember(id);
        return findById(id);
    }

    @Override
    public void delete(Long id) {
        committeeMemberRepository.delete(findById(id));
    }



}
