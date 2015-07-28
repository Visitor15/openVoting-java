package com.forged.openvoting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.voting_system.data.Ballot;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

/**
 * Created by visitor15 on 7/27/15.
 */
@JsonAutoDetect
public class BallotDTO {

    @Id
    private String id;

    private final Long upVoteCount;
    private final Long downVoteCount;

    private final Date creationDate;

    private final String description;
    private final String summary;

    private final Set<String> reasonsForBallot;

    private BallotDTO(final Ballot ballot) {
        this.id                 = ballot.getId();
        this.description        = ballot.getDescription();
        this.summary            = ballot.getSummary();
        this.creationDate       = ballot.getCreationDate();
        this.upVoteCount        = ballot.getUpVoteCount();
        this.downVoteCount      = ballot.getDownVoteCount();
        this.reasonsForBallot   = ballot.getReasonsForBallot();
    }

    public static BallotDTO from(final Ballot ballot) {
        return new BallotDTO(ballot);
    }

    public String getId() {
        return id;
    }

    public Long getUpVoteCount() {
        return upVoteCount;
    }

    public Long getDownVoteCount() {
        return downVoteCount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public Set<String> getReasonsForBallot() {
        return reasonsForBallot;
    }
}
