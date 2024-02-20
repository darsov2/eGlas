package mk.ukim.finki.eglas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn
public class CommitteeMember extends Citizen {
    @Override
    public String type() {
        return "committee";
    }
}
