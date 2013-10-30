package com.babamerzoug.feo.business.spi;

import com.babamerzoug.feo.domain.Desk;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/30/13
 * Time: 9:21 AM
 */
public interface DeskService {

    /**
     * @return <p>all Foreign Exchange Desks within system</p>
     */
    List<Desk> findAll();

    /**
     * <p>adds a desk to system</p>
     *
     * @param desk
     * @return
     */
    Desk add(Desk desk);

    /**
     * <p>removes a desk from system</p>
     *
     *
     * @param desk
     * @return
     */
    void remove(Desk desk);

    /**
     *
     * @param id
     * @return
     */
    Desk findById(String id);
}
