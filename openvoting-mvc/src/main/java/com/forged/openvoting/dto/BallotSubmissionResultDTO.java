package com.forged.openvoting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.support.web.ResultType;

/**
 * Created by visitor15 on 7/27/15.
 */
@JsonAutoDetect
public class BallotSubmissionResultDTO {

    private final ResultType resultType;

    private final String message;

    public BallotSubmissionResultDTO(final ResultType resultType, final String message) {
        this.resultType = resultType;
        this.message = message;
    }

    public ResultType getResultType() {
        return this.resultType;
    }

    public String getMessage() {
        return this.message;
    }
}
