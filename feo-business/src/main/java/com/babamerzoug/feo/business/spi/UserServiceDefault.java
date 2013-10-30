package com.babamerzoug.feo.business.spi;

import com.babamerzoug.feo.domain.User;
import com.babamerzoug.feo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 10/30/13
 * Time: 11:11 PM
 */
public class UserServiceDefault implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username"));
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public void remove(User user) {
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
