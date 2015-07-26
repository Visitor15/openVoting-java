package com.forged.openvoting.dao;

import com.forged.openvoting.voting_system.data.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by visitor15 on 7/25/15.
 */
@Service
public class VoteDataAccessor implements DataAccessor<Vote>{

    @Value("${mongodb.vote.collection-name}")
    private String collectionName;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Vote save(Vote vote) {
        mongoTemplate.save(vote, collectionName);
        return vote;
    }

    @Override
    public Vote findById(String id) {
        return null;
    }

    @Override
    public Vote update(Vote vote) {
        return null;
    }

    @Override
    public void delete(Vote vote) {

    }
}
