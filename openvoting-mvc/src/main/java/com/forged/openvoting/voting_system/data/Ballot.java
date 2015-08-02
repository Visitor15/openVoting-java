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
    public String id;

    private Long upVoteCount;
    private Long downVoteCount;

    private Date creationDate;

    private String title;
    private String description;
    private String summary;

    private Set<String> reasonsForBallot;

    private BallotGroup ballotGroup;

    public Ballot() {
        id = "";
        upVoteCount = 0L;
        downVoteCount = 0L;
        creationDate = new Date();
        title = "";
        description = "";
        summary = "";
        reasonsForBallot = new HashSet<String>();
        ballotGroup = new BallotGroup();
    }

    public Ballot(final String id,
                  final String title,
                  final String description,
                  final String summary,
                  final Date creationDate,
                  final Long upVoteCount,
                  final Long downVoteCount,
                  final BallotGroup ballotGroup,
                  final Set<String> reasonsForBallot) {
        this.id                 = id;
        this.title              = title;
        this.description        = description;
        this.summary            = summary;
        this.creationDate       = creationDate;
        this.upVoteCount        = upVoteCount;
        this.downVoteCount      = downVoteCount;
        this.reasonsForBallot   = reasonsForBallot;
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

    public void setId(String id) {
        this.id = id;
    }

    public Long getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(Long upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public Long getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(Long downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<String> getReasonsForBallot() {
        return reasonsForBallot;
    }

    public void setReasonsForBallot(Set<String> reasonsForBallot) {
        this.reasonsForBallot = reasonsForBallot;
    }

    public BallotGroup getBallotGroup() {
        return ballotGroup;
    }

    public void setBallotGroup(BallotGroup ballotGroup) {
        this.ballotGroup = ballotGroup;
    }
}
