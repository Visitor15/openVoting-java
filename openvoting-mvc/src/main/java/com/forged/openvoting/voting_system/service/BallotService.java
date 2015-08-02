package com.forged.openvoting.voting_system.service;

import com.forged.openvoting.dao.BallotDataAccessor;
import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.dto.BallotSubmissionResultDTO;
import com.forged.openvoting.support.web.ResultType;
import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.BallotSubmissionResult;
import com.forged.openvoting.voting_system.validation.BallotSubmissionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by visitor15 on 7/27/15.
 */
@Service
public class BallotService {

    @Autowired
    BallotDataAccessor ballotDataAccessor;

    @Autowired
    BallotSubmissionValidator ballotSubmissionValidator;

    public Ballot findBallotById(final String id) {
        return ballotDataAccessor.findById(id);
    }

    public BallotDTO findBallotDTOById(final String id) {
        return new BallotDTO(ballotDataAccessor.findById(id));
    }

    public BallotSubmissionResult submitBallotForVoting(final Ballot ballot) {
        return new BallotSubmissionResult();
    }

    public BallotSubmissionResultDTO submitBallotForVoting(final BallotDTO ballotDTO) {
        BallotSubmissionResultDTO ballotSubmissionResultDTO;
        Ballot ballotToSubmit = Ballot.from(ballotDTO);
        if(!ballotSubmissionValidator.validate(ballotToSubmit)) {
            ballotSubmissionResultDTO = generateFailedBallotSubmissionResponse(ballotDTO);
        } else {
            ballotDataAccessor.save(ballotToSubmit);
            ballotSubmissionResultDTO = generateSucceededBallotSubmissionResponse(ballotDTO);
        }
        return ballotSubmissionResultDTO;
    }

    private BallotSubmissionResultDTO generateFailedBallotSubmissionResponse(final BallotDTO ballotDTO) {
        BallotSubmissionResultDTO ballotSubmissionResultDTO = new BallotSubmissionResultDTO(ResultType.FAILURE, "Error submitting ballot");
        return ballotSubmissionResultDTO;
    }

    private BallotSubmissionResultDTO generateSucceededBallotSubmissionResponse(final BallotDTO ballotDTO) {
        BallotSubmissionResultDTO ballotSubmissionResultDTO = new BallotSubmissionResultDTO(ResultType.SUCCESS, "Successfully submitted ballot");
        return ballotSubmissionResultDTO;
    }
}