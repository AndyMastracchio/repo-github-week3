package com.dh.consultingroom.dao;

import java.util.List;

/**
 * It manages the operations & transaction on a DB
 * @param <T> Any object to be deleted, stored, updated & so on
 * @author Aponte
 */
public interface IDaoUsers <T> {

    /**
     * Store into DB information of <T> type
     * @param t object to be stored
     * @author Aponte
     */
    void save(T t);

    /**
     * Given an int name as id it removes a complete tuple
     * @param id tuple identifier
     * @author Aponte
     */
    void delete(int id);

    /**
     * Searches a tuple by its identifier in a DB
     * @param id tuple identifier
     * @return T an object with the tuple attributes
     * @author Aponte
     */
    T search(int id);

    /**
     * Returns all the tuples in a db
     * @return List of objects of any type
     * @author Aponte
     */
    List<T> searchAll();
}
