package com.forged.openvoting.voting_system.builders;

import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.BallotGroup;

import java.util.Date;
import java.util.Set;

/**
 * Created by visitor15 on 7/27/15.
 */
public class BallotBuilder implements Builder<Ballot> {

    private BallotBuilder instance;

    private String id;
    private String title;
    private String description;
    private String summary;

    private Long upVoteCount;
    private Long downVoteCount;

    private Date creationDate;

    private Set<String> reasonForBallot;

    private BallotGroup ballotGroup;

    public BallotBuilder builder() {
        return (instance == null) ? new BallotBuilder() : instance;
    }

    public BallotBuilder() {
        instance = this;
    }

    @Override
    public Ballot build() {
        return new Ballot(
                id,
                title,
                description,
                summary,
                creationDate,
                upVoteCount,
                downVoteCount,
                ballotGroup);
    }

    public BallotBuilder setId(final String id) {
        this.id = id;
        return instance;
    }

    public BallotBuilder setTitle(final String title) {
        this.title = title;
        return instance;
    }

    public BallotBuilder setUpVoteCount(final Long val) {
        this.upVoteCount = val;
        return instance;
    }

    public BallotBuilder setDownVoteCount(final Long val) {
        this.downVoteCount = val;
        return instance;
    }

    public BallotBuilder setDescription(final String description) {
        this.description = description;
        return instance;
    }

    public BallotBuilder setSummary(final String summary) {
        this.summary = summary;
        return instance;
    }

    public BallotBuilder setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
        return instance;
    }

    public BallotBuilder setBallotGroup(final BallotGroup ballotGroup) {
        this.ballotGroup = ballotGroup;
        return instance;
    }

    public BallotBuilder setReasonForBallot(final Set<String> reasonForBallot) {
        this.reasonForBallot = reasonForBallot;
        return instance;
    }
}
