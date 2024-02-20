package mk.ukim.finki.eglas.repository;

import mk.ukim.finki.eglas.model.Vote;
import mk.ukim.finki.eglas.model.VotingCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingCodeRepository extends JpaRepository<VotingCode, Long> {

    VotingCode findByCode(String code);
}
