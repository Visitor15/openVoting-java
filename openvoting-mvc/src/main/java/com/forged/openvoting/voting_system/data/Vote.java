package com.forged.openvoting.voting_system.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by visitor15 on 7/25/15.
 */
@JsonAutoDetect
public class Vote {

    public void setId(String id) {
        this.id = id;
    }

    public void setVoteOwner(String voteOwner) {
        this.voteOwner = voteOwner;
    }

    public void setBallotId(String ballotId) {
        this.ballotId = ballotId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Vote() {

    }

    @Id
    private String id;

    private String voteOwner;
    private String ballotId;

    private Date creationDate;

    public Vote(final String id,
                final String voteOwner,
                final String ballotId,
                final Date creationDate) {
        this.id             = id;
        this.voteOwner      = voteOwner;
        this.ballotId       = ballotId;
        this.creationDate   = creationDate;
    }

    public Vote(final String id,
                final String voteOwner,
                final String ballotId) {
        this.id             = id;
        this.voteOwner      = voteOwner;
        this.ballotId       = ballotId;
        this.creationDate   = new Date();
    }

    public String getId() {
        return id;
    }

    public String getVoteOwner() {
        return voteOwner;
    }

    public String getBallotId() {
        return ballotId;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

