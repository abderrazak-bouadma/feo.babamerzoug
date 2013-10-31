package com.babamerzoug.feo.business;

import com.babamerzoug.feo.business.spi.UserService;
import com.babamerzoug.feo.domain.User;
import com.babamerzoug.feo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/31/13
 * Time: 3:58 PM
 */
@Service
public class UserServiceDefault implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
