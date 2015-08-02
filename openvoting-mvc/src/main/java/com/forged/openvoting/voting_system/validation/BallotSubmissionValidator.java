package com.forged.openvoting.voting_system.validation;

import com.forged.openvoting.dao.BallotDataAccessor;
import com.forged.openvoting.voting_system.data.Ballot;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by visitor15 on 8/1/15.
 */
public class BallotSubmissionValidator implements Validator<Ballot> {

    @Autowired
    BallotDataAccessor ballotDataAccessor;

    @Override
    public Boolean validate(Ballot ballot) {
        assertBallotDoesNotExist(ballot);
        assertBallotValidation(ballot);
        assertIdNotNull(ballot);
        assertHasTitleText(ballot);
        assertHasDescriptionText(ballot);

        if(ballot.hasErrors()) {
            return false;
        }
        return true;
    }

    private Boolean assertBallotDoesNotExist(final Ballot ballot) {
        Ballot foundBallot = ballotDataAccessor.findById(ballot.getId());
        if(foundBallot != null) {
            ballot.getErrors().add(new IllegalArgumentException("Ballot " + ballot.getId() + " already exists"));
            return false;
        }
        return true;
    }

    private Boolean assertIdNotNull(final Ballot ballot) {
        if(Strings.isNullOrEmpty(ballot.getId())) {
            ballot.getErrors().add(new IllegalArgumentException("No id found for ballot"));
            return false;
        }
        return true;
    }

    private Boolean assertHasTitleText(final Ballot ballot) {
        if(Strings.isNullOrEmpty(ballot.getTitle())) {
            ballot.getErrors().add(new IllegalArgumentException("Title not found"));
            return false;
        }
        return true;
    }

    private Boolean assertHasDescriptionText(final Ballot ballot) {
        if(Strings.isNullOrEmpty(ballot.getDescription())) {
            ballot.getErrors().add(new IllegalArgumentException("Description not found"));
            return false;
        }
        return true;
    }

    private Boolean assertBallotValidation(final Ballot ballot) {
        return true;
    }
}
