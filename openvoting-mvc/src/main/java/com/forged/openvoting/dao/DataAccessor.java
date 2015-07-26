package com.forged.openvoting.dao;

/**
 * Created by visitor15 on 7/25/15.
 */
public interface DataAccessor<T> {

    public T save(final T t);

    public T findById(final String id);

    public T update(final T t);

    public void delete(final T t);
}
