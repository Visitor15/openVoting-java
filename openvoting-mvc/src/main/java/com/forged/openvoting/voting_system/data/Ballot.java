package com.forged.openvoting.voting_system.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.voting_system.factories.BallotGroupFactory;
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

    private final String title;
    private final String description;
    private final String summary;

    private final Set<String> reasonsForBallot;

    private final BallotGroup ballotGroup;

    public Ballot() {
        upVoteCount = 0L;
        downVoteCount = 0L;
        creationDate = new Date();
        title = "";
        description = "";
        summary = "";
        reasonsForBallot = new HashSet<String>();
        ballotGroup = BallotGroupFactory.buildPublicBallotGroup();
    }

    public Ballot(final String id,
                  final String title,
                  final String description,
                  final String summary,
                  final Date creationDate,
                  final Long upVoteCount,
                  final Long downVoteCount,
                  final BallotGroup ballotGroup) {
        this.id                 = id;
        this.title              = title;
        this.description        = description;
        this.summary            = summary;
        this.creationDate       = creationDate;
        this.upVoteCount        = upVoteCount;
        this.downVoteCount      = downVoteCount;
        this.reasonsForBallot   = new HashSet<String>();
        this.ballotGroup        = ballotGroup;
    }

    public Ballot(final BallotDTO ballotDTO) {
        this.id                 = ballotDTO.getId();
        this.title              = ballotDTO.getTitle();
        this.description        = ballotDTO.getDescription();
        this.summary            = ballotDTO.getSummary();
        this.creationDate       = ballotDTO.getCreationDate();
        this.upVoteCount        = ballotDTO.getUpVoteCount();
        this.downVoteCount      = ballotDTO.getDownVoteCount();
        this.reasonsForBallot   = ballotDTO.getReasonsForBallot();
        this.ballotGroup        = ballotDTO.getBallotGroup();
    }

    public static Ballot from(final BallotDTO ballotDTO) {
        return new Ballot(ballotDTO);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public BallotGroup getBallotGroup() {
        return ballotGroup;
    }
}
