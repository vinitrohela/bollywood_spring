package com.allstate.controllers;

import com.allstate.entities.Movies;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private MovieService service;

    @Autowired
    public void setService(MovieService service) {
        this.service = service;
    }

    @RequestMapping(value = {"","/"}, method= RequestMethod.POST)
    public Movies create(@RequestBody Movies movies){
       // Movies x = this.service
        return this.service.create(movies);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movies findById(@PathVariable int id) {
        return this.service.findById(id);
    }
}
