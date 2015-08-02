package com.forged.openvoting.voting_system.data;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by visitor15 on 8/2/15.
 */
public class ErrorProneEntity {

    private List<Exception> errors = new LinkedList<>();

    public List<Exception> getErrors() {
        return this.errors;
    }

    public List<String> getErrorMessages() {
        List<String> messages = new LinkedList<String>();
        for(Exception e : this.getErrors()) {
            messages.add(e.getMessage());
        }
        return messages;
    }

    public Boolean hasErrors() {
        return this.errors.size() > 0;
    }
}
