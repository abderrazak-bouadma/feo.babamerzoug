package com.babamerzoug.feo.controller;

import com.babamerzoug.feo.business.DeskServiceDefault;
import com.babamerzoug.feo.domain.Desk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 10/29/13
 * Time: 10:43 PM
 */
@Controller
public class DeskController {

    @Autowired
    private DeskServiceDefault deskService;

    @RequestMapping(value = "/desks", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Desk> findAllDesks() {
        return deskService.findAll();
    }

    @RequestMapping(value = "/desks/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Desk findById(@PathVariable String id) {
        return deskService.findById(id);
    }

    @RequestMapping(value = "/desks", method = RequestMethod.PUT)
    @ResponseBody
    public Desk push(@RequestBody Desk desk) {
        return deskService.add(desk);
    }

    @RequestMapping(value = "/desks", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void remove(@RequestBody Desk desk) {
        deskService.remove(desk);
    }
}
