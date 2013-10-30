package com.babamerzoug.feo.business;

import com.babamerzoug.feo.business.spi.DeskService;
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
public class DeskServiceDefault implements DeskService {


    @Autowired
    private DeskRepository deskRepository;

    @Override
    public List<Desk> findAll() {
        return deskRepository.findAll();
    }

    @Override
    public Desk add(Desk desk) {
        return deskRepository.save(desk);
    }

    @Override
    public void remove(Desk desk) {
        deskRepository.delete(desk);
    }

    @Override
    public Desk findById(String id) {
        return deskRepository.findOne(id);
    }
}