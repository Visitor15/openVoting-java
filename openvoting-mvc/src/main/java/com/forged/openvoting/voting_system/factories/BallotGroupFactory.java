package com.forged.openvoting.voting_system.factories;

import com.forged.openvoting.voting_system.data.BallotGroup;

/**
 * Created by visitor15 on 7/29/15.
 */
public class BallotGroupFactory {

    public static BallotGroup buildPublicBallotGroup() {
        return new BallotGroup();
    }
}
