package com.babamerzoug.feo.business.spi;

import com.babamerzoug.feo.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/31/13
 * Time: 3:58 PM
 */
public interface UserService {

    List<User> findAll();
}
