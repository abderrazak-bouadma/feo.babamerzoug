package com.babamerzoug.feo.repository;

import com.babamerzoug.feo.domain.Desk;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:23 PM
 */
public interface DeskRepository extends MongoRepository<Desk,String> {

}
