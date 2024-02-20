package mk.ukim.finki.eglas.services;
import mk.ukim.finki.eglas.model.Committee;

import java.util.List;

public interface CommitteeService {
    Committee findById(Long id);
    List<Committee> findAll();
    void delete(Long id);
    Committee update(Long id, Long pollingStationId, Long electionRealizationId);
    void addMemberToCommittee(Long committeeId, Long committeeMemberId);
}
