package com.forged.openvoting.voting_system.service;

import com.forged.openvoting.voting_system.data.Vote;
import com.forged.openvoting.voting_system.data.VoteSubmissionResult;
import com.forged.openvoting.voting_system.data.VotingResult;
import org.springframework.stereotype.Service;

/**
 * Created by visitor15 on 7/25/15.
 */
@Service
public class VotingService {

    public VotingResult vote(final String voteId, final Vote vote) {
//        return VotingResult.builder().build();
        return null;
    }

    public VoteSubmissionResult submitVote(final Vote vote) {
//        return VoteSubmissionResult.builder().build();
        return null;
    }
}
