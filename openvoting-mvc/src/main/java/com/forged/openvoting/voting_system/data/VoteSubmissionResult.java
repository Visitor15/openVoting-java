package com.forged.openvoting.voting_system.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by visitor15 on 7/25/15.
 */
@Data
@Builder
@AllArgsConstructor
public class VoteSubmissionResult {

    // What does this consist of?

    // Were there issues submitting the vote?
    //      - duplicate?
    //      - sanatized?
    //      - preconditions met?
}
