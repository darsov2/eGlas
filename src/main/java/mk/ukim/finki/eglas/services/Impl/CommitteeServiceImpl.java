package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.Committee;
import mk.ukim.finki.eglas.repository.CommitteeRepository;
import mk.ukim.finki.eglas.services.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    private final CommitteeMemberService committeeMemberService;
    private final CommitteeRepository committeeRepository;
    private final AddressService addressService;
    private final ElectionRealizationService electionRealizationService;

    public CommitteeServiceImpl(CommitteeMemberService committeeMemberService,
                                CommitteeRepository committeeRepository,
                                AddressService addressService,
                                ElectionRealizationService electionRealizationService) {
        this.committeeMemberService = committeeMemberService;
        this.committeeRepository = committeeRepository;
        this.addressService = addressService;
        this.electionRealizationService = electionRealizationService;
    }

    @Override
    public Committee findById(Long id) {
        return committeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Committee not found"));
    }

    @Override
    public List<Committee> findAll() {
        return committeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        committeeRepository.delete(findById(id));
    }

    @Override
    public Committee update(Long id, Long pollingStationId, Long electionRealizationId) {
        Committee committee = new Committee();
        if (id != null){
            committee = findById(id);
        }
        committee.setPollingStation(addressService.findPollingStationById(pollingStationId));
        committee.setElectionRealization(electionRealizationService.    findById(electionRealizationId));
        return committeeRepository.save(committee);
    }

    @Override
    public void addMemberToCommittee(Long committeeId, Long committeeMemberId) {
        Committee committee = findById(committeeId);
        committee.getMembers().add(committeeMemberService.findById(committeeMemberId));
        committeeRepository.save(committee);
    }
}
