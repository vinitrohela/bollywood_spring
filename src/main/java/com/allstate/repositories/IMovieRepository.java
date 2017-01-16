package com.allstate.repositories;

import com.allstate.entities.Movies;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movies, Integer>{
}
