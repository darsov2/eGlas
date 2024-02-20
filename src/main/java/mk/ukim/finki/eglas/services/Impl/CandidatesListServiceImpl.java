package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.CandidatesList;
import mk.ukim.finki.eglas.repository.CandidatesListRepository;
import mk.ukim.finki.eglas.services.CandidateService;
import mk.ukim.finki.eglas.services.CandidatesListElectionRealizationService;
import mk.ukim.finki.eglas.services.CandidatesListService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatesListServiceImpl implements CandidatesListService {
    private final CandidatesListRepository repository;
    private final CandidatesListElectionRealizationService candidatesListElectionRealizationService;
    private final CandidateService candidateService;

    public CandidatesListServiceImpl(CandidatesListRepository repository,
                              CandidatesListElectionRealizationService candidatesListElectionRealizationService,
                              CandidateService candidateService){
        this.repository = repository;
        this.candidatesListElectionRealizationService = candidatesListElectionRealizationService;
        this.candidateService = candidateService;
    }

    @Override
    public CandidatesList findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No candidates list found"));
    }

    @Override
    public List<CandidatesList> findAll() {
        return repository.findAll();
    }

    @Override
    public CandidatesList update(Long id, String description, Long candidatesListElectionRealizationId) {
        CandidatesList list = new CandidatesList();
        if (id != null) {
            list = findById(id);
        }
        list.setDescription(description);
        list.setCandidatesListElectionRealization(candidatesListElectionRealizationService.findById(candidatesListElectionRealizationId));
        return repository.save(list);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public void addCandidateToCandidatesList(Long candidatesListId, Long candidateId) {
        CandidatesList list = findById(candidatesListId);
        list.getCandidates().add(candidateService.findById(candidateId));
    }
}
