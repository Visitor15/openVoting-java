package com.forged.openvoting.dao;

import com.forged.openvoting.voting_system.data.Ballot;
import com.forged.openvoting.voting_system.data.Location;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;

import java.util.Iterator;

/**
 * Created by visitor15 on 7/25/15.
 */
public interface DataAccessor<T> {

    public T save(final T t);

    public T findById(final String id);

    public Iterator<GeoResult<Ballot>> findByLocation(final Point location);

    public T update(final T t);

    public void delete(final T t);
}
