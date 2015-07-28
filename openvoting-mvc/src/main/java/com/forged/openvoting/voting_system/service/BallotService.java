package com.forged.openvoting.voting_system.service;

import com.forged.openvoting.dao.BallotDataAccessor;
import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.dto.BallotSubmissionResultDTO;
import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.BallotSubmissionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by visitor15 on 7/27/15.
 */
@Service
public class BallotService {

    @Autowired
    BallotDataAccessor ballotDataAccessor;

    public Ballot findBallotById(final String id) {
        return ballotDataAccessor.findById(id);
    }

    public BallotDTO findBallotDTOById(final String id) {
        return BallotDTO.from(ballotDataAccessor.findById(id));
    }

    public BallotSubmissionResult submitBallotForVoting(final Ballot ballot) {
        return new BallotSubmissionResult();
    }

    public BallotSubmissionResultDTO submitBallotForVoting(final BallotDTO ballotDTO) {
        return new BallotSubmissionResultDTO();
    }
}
