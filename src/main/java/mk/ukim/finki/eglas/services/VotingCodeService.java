package mk.ukim.finki.eglas.services;

import mk.ukim.finki.eglas.model.VotingCode;

import java.util.List;

public interface VotingCodeService {
    List<VotingCode> findAll();
    VotingCode findByCode(String code);
    VotingCode update(Long id, String name, Long addressId);
    VotingCode delete(Long id);
}
