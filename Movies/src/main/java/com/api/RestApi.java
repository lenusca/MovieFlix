package com.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.Models.Movie;
import com.Models.Search;
import com.Models.Serie;
import com.dbcontroller.MovieRepository;
import com.dbcontroller.SearchRepository;
import com.dbcontroller.SerieRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
public class RestApi {
	
	// criar a minha propria para por na web 
	static RestTemplate restTemplate = new RestTemplate();
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	SearchRepository moviesRepository;
	
	@Autowired
	SerieRepository serieRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Movie/", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> Movie() {
			
		Iterable<Movie> movie = movieRepository.findAll();
		List<Movie> c = new ArrayList<Movie>();
		movie.forEach(e -> c.add(e));
		
			
		return new ResponseEntity<List<Movie>>(c, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Movies/", method = RequestMethod.GET)
	public ResponseEntity<List<Search>> Movies() {
			
		Iterable<Search> movie = moviesRepository.findAll();
		List<Search> c = new ArrayList<Search>();
		movie.forEach(e -> c.add(e));
		
			
		return new ResponseEntity<List<Search>>(c, HttpStatus.OK);		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/Serie/", method = RequestMethod.GET)
	public ResponseEntity<List<Serie>> Serie() {
			
		Iterable<Serie> serie = serieRepository.findAll();
		List<Serie> c = new ArrayList<Serie>();
		serie.forEach(e -> c.add(e));
		
			
		return new ResponseEntity<List<Serie>>(c, HttpStatus.OK);		
	}

}
