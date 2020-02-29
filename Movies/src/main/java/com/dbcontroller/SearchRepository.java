package com.dbcontroller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Models.Search;

@Repository
public interface SearchRepository extends CrudRepository<Search, String>{

}
