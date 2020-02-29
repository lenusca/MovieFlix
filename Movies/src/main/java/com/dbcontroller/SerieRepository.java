package com.dbcontroller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.Serie;

@Repository
public interface SerieRepository extends CrudRepository<Serie, String>{

}
