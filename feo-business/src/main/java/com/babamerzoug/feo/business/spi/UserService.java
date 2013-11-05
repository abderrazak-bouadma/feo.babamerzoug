package com.babamerzoug.feo.business.spi;

import com.babamerzoug.feo.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 10/30/13
 * Time: 11:08 PM
 */
public interface UserService {

    User findByUsername(String username);

    User create(User user);

    void remove(User user);

    List<User> findAll();
}
