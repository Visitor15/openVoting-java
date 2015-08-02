package com.forged.openvoting.dao;

import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Iterator;

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
    public Iterator<GeoResult<Ballot>> findByLocation(Point location) {
        return mongoTemplate.geoNear(buildLocationQuery(location), Ballot.class, collectionName).iterator();
    }

    @Override
    public Ballot update(Ballot ballot) {
        return null;
    }

    @Override
    public void delete(Ballot ballot) {

    }

    private Query buildQueryToFindById(final String id) {
        return new Query().addCriteria(Criteria.where("_id").is(id));
    }

    private NearQuery buildLocationQuery(final Point location) {
        return NearQuery.near(location).maxDistance(new Distance(10, Metrics.MILES));
    }
}
