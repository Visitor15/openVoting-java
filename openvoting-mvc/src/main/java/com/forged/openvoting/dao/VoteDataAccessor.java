package com.forged.openvoting.dao;

import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Iterator;

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
        Vote foundVote = mongoTemplate.findOne(buildQueryToFindById(id), Vote.class, collectionName);
        return foundVote;
    }

    @Override
    public Iterator<GeoResult<Ballot>> findByLocation(Point location) {
        return null;
    }

    @Override
    public Vote update(Vote vote) {
        return null;
    }

    @Override
    public void delete(Vote vote) {

    }

    private Query buildQueryToFindById(final String id) {
        return new Query().addCriteria(Criteria.where("id").is(id));
    }
}
