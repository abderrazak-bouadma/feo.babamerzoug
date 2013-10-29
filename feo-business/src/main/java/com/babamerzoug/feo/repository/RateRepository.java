package com.babamerzoug.feo.repository;

import com.babamerzoug.feo.domain.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:25 PM
 */
public interface RateRepository extends MongoRepository<Rate,String> {
}
