package com.bruyako;

import java.util.List;

/**
 * Created by brunyatko on 24.09.15.
 */
public interface AbstractDao<T, P> {

    P create(T t);
    void delete(T t);
    T getById(P p);
}
