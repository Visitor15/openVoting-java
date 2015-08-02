package com.forged.openvoting.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.forged.openvoting.support.web.ResultType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by visitor15 on 7/27/15.
 */
@JsonAutoDetect
public class BallotSubmissionResultDTO {

    private final ResultType resultType;

    private final List<String> messages;

    public BallotSubmissionResultDTO(final ResultType resultType, final List<String> messages) {
        this.resultType = resultType;
        this.messages = messages;
    }

    public BallotSubmissionResultDTO(final ResultType resultType, final String message) {
        this.resultType = resultType;
        this.messages = new LinkedList<String>() {{ add(message); }};
    }

    public ResultType getResultType() {
        return this.resultType;
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
