package com.dbcontroller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String>{

}
