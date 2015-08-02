package com.forged.openvoting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.BallotGroup;
import com.forged.openvoting.voting_system.data.Location;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by visitor15 on 7/27/15.
 */
@JsonAutoDetect
public class BallotDTO {

    @Id
    private String id;

    private Long upVoteCount;
    private Long downVoteCount;

    private Date creationDate;

    private String title;
    private String description;
    private String summary;

    private Set<String> reasonsForBallot;

    private BallotGroup ballotGroup;

    private Location location;

    public BallotDTO() {
        upVoteCount         = 0L;
        downVoteCount       = 0L;
        creationDate        = new Date();
        title               = "";
        description         = "";
        summary             = "";
        reasonsForBallot    = new HashSet<String>();
        ballotGroup         = new BallotGroup();
        location            = new Location();
    }

    public BallotDTO(final Ballot ballot) {
        this.id                 = ballot.getId();
        this.title              = ballot.getTitle();
        this.description        = ballot.getDescription();
        this.summary            = ballot.getSummary();
        this.creationDate       = ballot.getCreationDate();
        this.upVoteCount        = ballot.getUpVoteCount();
        this.downVoteCount      = ballot.getDownVoteCount();
        this.reasonsForBallot   = ballot.getReasonsForBallot();
        this.ballotGroup        = ballot.getBallotGroup();
        this.location           = ballot.getLocation();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUpVoteCount(Long upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public void setDownVoteCount(Long downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setReasonsForBallot(Set<String> reasonsForBallot) {
        this.reasonsForBallot = reasonsForBallot;
    }

    public void setBallotGroup(BallotGroup ballotGroup) {
        this.ballotGroup = ballotGroup;
    }

//    public static BallotDTO from(final Ballot ballot) {
//        return new BallotDTO(ballot);
//    }

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

    public Location getLocation() {
        return location;
    }
}
