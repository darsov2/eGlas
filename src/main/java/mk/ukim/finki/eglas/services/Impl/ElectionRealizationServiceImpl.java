package mk.ukim.finki.eglas.services.Impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.eglas.model.Election;
import mk.ukim.finki.eglas.model.ElectionRealization;
import mk.ukim.finki.eglas.repository.CandidatesElectionRealizationRepository;
import mk.ukim.finki.eglas.repository.CandidatesListElectionRealizationRepository;
import mk.ukim.finki.eglas.repository.ElectionRealizationRepository;
import mk.ukim.finki.eglas.services.ElectionRealizationService;
import mk.ukim.finki.eglas.services.ElectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ElectionRealizationServiceImpl implements ElectionRealizationService {
    private final ElectionRealizationRepository electionRealizationRepository;
    private final CandidatesListElectionRealizationRepository candidatesListElectionRealizationRepository;
    private final CandidatesElectionRealizationRepository candidatesElectionRealizationRepository;
    private final ElectionService electionService;

    public ElectionRealizationServiceImpl(ElectionRealizationRepository electionRealizationRepository, CandidatesListElectionRealizationRepository candidatesListElectionRealizationRepository, CandidatesElectionRealizationRepository candidatesElectionRealizationRepository, ElectionService electionService) {
        this.electionRealizationRepository = electionRealizationRepository;
        this.candidatesListElectionRealizationRepository = candidatesListElectionRealizationRepository;
        this.candidatesElectionRealizationRepository = candidatesElectionRealizationRepository;
        this.electionService = electionService;
    }

    @Override
    public List<ElectionRealization> findAll() {
        return electionRealizationRepository.findAll();
    }

    @Override
    public ElectionRealization findById(Long id) {
        return electionRealizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Election Realization not found"));
    }

    @Override
    @Transactional
    public ElectionRealization update(Long id, LocalDate date, String name, Long electionId, String candidacyRealization, String candidatesListRealization) {
        Election election = electionService.findById(electionId);
        ElectionRealization electionRealization = new ElectionRealization();
        if(id != null)
        {
            electionRealization = findById(id);
        }
        electionRealization.setElection(election);
        electionRealization.setName(name);
        electionRealization.setDate(date);
        electionRealization = electionRealizationRepository.save(electionRealization);
        if(candidacyRealization != null)
        {
            candidatesElectionRealizationRepository.insertCandidacyElections(electionRealization.getId());
        }
        if(candidatesListRealization != null)
        {
            candidatesListElectionRealizationRepository.insertCandidateListElections(electionRealization.getId());
        }
        return electionRealization;
    }

    @Override
    public ElectionRealization delete(Long id) {
        ElectionRealization electionRealization = findById(id);
        electionRealizationRepository.delete(electionRealization);
        return electionRealization;
    }
}
