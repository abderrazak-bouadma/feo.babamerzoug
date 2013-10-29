package com.babamerzoug.feo.repository;

import com.babamerzoug.feo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:24 PM
 */
public interface UserRepository extends MongoRepository<User,String>{
}
