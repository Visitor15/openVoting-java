package com.forged.openvoting.voting_system.service;

import com.forged.openvoting.dao.BallotDataAccessor;
import com.forged.openvoting.dto.BallotDTO;
import com.forged.openvoting.dto.BallotSubmissionResultDTO;
import com.forged.openvoting.support.web.ResultType;
import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.BallotSubmissionResult;
import com.forged.openvoting.voting_system.validation.BallotSubmissionValidator;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        if(Strings.isNullOrEmpty(ballotToSubmit.getId())) {
            ballotToSubmit.setId(UUID.randomUUID().toString());
        }
        if(!ballotSubmissionValidator.validate(ballotToSubmit)) {
            ballotSubmissionResultDTO = generateFailedBallotSubmissionResponse(ballotToSubmit);
        } else {
            ballotDataAccessor.save(ballotToSubmit);
            ballotSubmissionResultDTO = generateSucceededBallotSubmissionResponse(ballotToSubmit);
        }
        return ballotSubmissionResultDTO;
    }

    private BallotSubmissionResultDTO generateFailedBallotSubmissionResponse(final Ballot ballot) {
        BallotSubmissionResultDTO ballotSubmissionResultDTO = new BallotSubmissionResultDTO(ResultType.FAILURE, ballot.getErrorMessages());
        return ballotSubmissionResultDTO;
    }

    private BallotSubmissionResultDTO generateSucceededBallotSubmissionResponse(final Ballot ballotDTO) {
        BallotSubmissionResultDTO ballotSubmissionResultDTO = new BallotSubmissionResultDTO(ResultType.SUCCESS, "Successfully submitted ballot");
        ballotSubmissionResultDTO.setBallotId(ballotDTO.getId());
        return ballotSubmissionResultDTO;
    }
}