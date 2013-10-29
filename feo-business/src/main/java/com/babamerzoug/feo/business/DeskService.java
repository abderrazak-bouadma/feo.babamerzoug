package com.babamerzoug.feo.business;

import com.babamerzoug.feo.domain.Desk;
import com.babamerzoug.feo.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/29/13
 * Time: 5:28 PM
 */
@Service
public class DeskService {

    @Autowired
    private DeskRepository exchangeDeskRepository;

    public List<Desk> findAll() {
        return exchangeDeskRepository.findAll();
    }
}
