package com.babamerzoug.feo.controller;

import com.babamerzoug.feo.business.DeskService;
import com.babamerzoug.feo.domain.Desk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 10/29/13
 * Time: 10:43 PM
 */
public class DeskController {

    @Autowired
    private DeskService deskService;

    @RequestMapping("/desks")
    public @ResponseBody List<Desk> findAllDesks() {
        return deskService.findAll();
    }
}
