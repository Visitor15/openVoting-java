package com.forged.openvoting.config;

import com.forged.openvoting.voting_system.validation.BallotSubmissionValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by visitor15 on 8/1/15.
 */
@Configuration
public class DataValidatorConfig {

    @Bean(name = "ballotSubmissionValidator")
    public BallotSubmissionValidator ballotSubmissionValidator() {
        return new BallotSubmissionValidator();
    }
}
