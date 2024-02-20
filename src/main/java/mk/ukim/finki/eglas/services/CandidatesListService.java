package mk.ukim.finki.eglas.services;

import mk.ukim.finki.eglas.model.CandidatesList;

import java.util.List;

public interface CandidatesListService {
    CandidatesList findById(Long id);
    List<CandidatesList> findAll();
    CandidatesList update(Long id, String description, Long candidatesListElectionRealizationId);
    void delete(Long id);

    void addCandidateToCandidatesList(Long candidatesListId, Long candidateId);
}
