package com.forged.openvoting.voting_system.builders;

import com.forged.openvoting.voting_system.data.Ballot;

import java.util.Date;

/**
 * Created by visitor15 on 7/27/15.
 */
public class BallotBuilder implements Builder<Ballot> {

    private static BallotBuilder instance;

    private String id;
    private String description;
    private String summary;

    private Long upVoteCount;
    private Long downVoteCount;

    private Date creationDate;

    public static BallotBuilder builder() {
        return (instance == null) ? new BallotBuilder() : instance;
    }

    private BallotBuilder() {
        instance = this;
    }

    @Override
    public Ballot build() {
        return new Ballot(
                id,
                description,
                summary,
                creationDate,
                upVoteCount,
                downVoteCount);
    }

    public BallotBuilder setId(final String id) {
        this.id = id;
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
}
