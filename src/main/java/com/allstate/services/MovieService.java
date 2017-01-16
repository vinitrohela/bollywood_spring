package com.allstate.services;

import com.allstate.entities.Movies;
import com.allstate.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private IMovieRepository respository;

    @Autowired
    public void setRespository(IMovieRepository respository) {
        this.respository = respository;
    }

    public Movies create(Movies m){
        return this.respository.save(m);
    }

    public Movies findById(int id){
        return this.respository.findOne(id);
    }

    public Iterable<Movies> findAll() {
        return this.respository.findAll();
    }

    public Movies findByTitle(String title){
        return this.respository.findByTitle(title);
    }

    public void delete(int id) {
        this.respository.delete(id);
    }

    public Movies updateTitle(Movies m){
        m.setTitle("Nirmal");
        return m;
    }
}
