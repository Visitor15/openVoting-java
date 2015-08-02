package com.forged.openvoting.voting_system.validation;

/**
 * Created by visitor15 on 8/1/15.
 */
public interface Validator<T> {

    Boolean validate(T object);
}
