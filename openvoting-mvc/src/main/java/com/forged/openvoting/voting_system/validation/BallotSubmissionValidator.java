package com.forged.openvoting.voting_system.validation;

import com.forged.openvoting.dao.BallotDataAccessor;
import com.forged.openvoting.voting_system.data.Ballot;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by visitor15 on 8/1/15.
 */
public class BallotSubmissionValidator implements Validator<Ballot> {

    @Autowired
    BallotDataAccessor ballotDataAccessor;

    @Override
    public Boolean validate(Ballot ballot) {

        if(!assertBallotDoesNotExist(ballot) ||
           !assertBallotValidation(ballot)) {
            return false;
        }
        return true;
    }

    private Boolean assertBallotDoesNotExist(final Ballot ballot) {
        return ballotDataAccessor.findById(ballot.getId()) == null;
    }

    private Boolean assertBallotValidation(final Ballot ballot) {
        return true;
    }
}
