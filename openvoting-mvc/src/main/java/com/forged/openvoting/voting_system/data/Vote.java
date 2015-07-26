package com.forged.openvoting.voting_system.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by visitor15 on 7/25/15.
 */
@Data
@Builder
@AllArgsConstructor
public class Vote {

    // number up upVotes
    // number of downVotes
    // description
    // summary
    // reasons for vote*

    @Id
    private String id;

    private final Long upVoteCount;
    private final Long downVoteCount;

    private final Date creationDate;

    private final String description;
    private final String summary;

    private final Set<String> reasonsForVote;

    public Vote() {
        upVoteCount = 0L;
        downVoteCount = 0L;
        creationDate = new Date();
        description = "";
        summary = "";
        reasonsForVote = new HashSet<String>();
    }
}

