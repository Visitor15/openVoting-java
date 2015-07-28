package com.forged.openvoting.voting_system.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.dto.BallotDTO;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by visitor15 on 7/25/15.
 */
@JsonAutoDetect
public class Ballot {

    @Id
    private String id;

    private final Long upVoteCount;
    private final Long downVoteCount;

    private final Date creationDate;

    private final String description;
    private final String summary;

    private final Set<String> reasonsForBallot;

    public Ballot() {
        upVoteCount = 0L;
        downVoteCount = 0L;
        creationDate = new Date();
        description = "";
        summary = "";
        reasonsForBallot = new HashSet<String>();
    }

    public Ballot(final String id,
                  final String description,
                  final String summary,
                  final Date creationDate,
                  final Long upVoteCount,
                  final Long downVoteCount) {
        this.id                 = id;
        this.description        = description;
        this.summary            = summary;
        this.creationDate       = creationDate;
        this.upVoteCount        = upVoteCount;
        this.downVoteCount      = downVoteCount;
        this.reasonsForBallot   = new HashSet<String>();
    }

    public Ballot(final BallotDTO ballotDTO) {
        this.id                 = ballotDTO.getId();
        this.description        = ballotDTO.getDescription();
        this.summary            = ballotDTO.getSummary();
        this.creationDate       = ballotDTO.getCreationDate();
        this.upVoteCount        = ballotDTO.getUpVoteCount();
        this.downVoteCount      = ballotDTO.getDownVoteCount();
        this.reasonsForBallot   = ballotDTO.getReasonsForBallot();
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
