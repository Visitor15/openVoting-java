package com.forged.openvoting.dao;

import com.forged.openvoting.voting_system.data.Ballot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by visitor15 on 7/26/15.
 */
public class BallotDataAccessor implements DataAccessor<Ballot> {

    @Value("${mongodb.ballot.collection-name}")
    private String collectionName;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Ballot save(Ballot ballot) {
        mongoTemplate.save(ballot, collectionName);
        return ballot;
    }

    @Override
    public Ballot findById(String id) {
        Ballot foundBallot = mongoTemplate.findOne(buildQueryToFindById(id), Ballot.class, collectionName);
        return foundBallot;
    }

    @Override
    public Ballot update(Ballot ballot) {
        return null;
    }

    @Override
    public void delete(Ballot ballot) {

    }

    private Query buildQueryToFindById(final String id) {
        return new Query().addCriteria(Criteria.where("id").is(id));
    }
}
