package com.allstate.controllers;

import com.allstate.entities.Movies;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return this.service.create(movies);
    }
}
