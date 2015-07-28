package com.forged.openvoting.voting_system.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by visitor15 on 7/25/15.
 */
@JsonAutoDetect
public class Vote {

    @Id
    private final String id;

    private final String voteOwner;
    private final String ballotId;

    private final Date creationDate;

    public Vote(final String id,
                final String voteOwner,
                final String ballotId,
                final Date creationDate) {
        this.id             = id;
        this.voteOwner      = voteOwner;
        this.ballotId       = ballotId;
        this.creationDate   = creationDate;
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

